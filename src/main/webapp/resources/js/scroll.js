/* mousescroll.js */
(function (root, factory) {
	if ( typeof define === 'function' && define.amd ) {
		define('smoothScroll', factory(root));
	} else if ( typeof exports === 'object' ) {
		module.smoothScroll = factory(root);
	} else {
		root.smoothScroll = factory(root);
	}
})(this, function (root) {

	'use strict';

	//
	// Variables
	//

	var exports = {}; // Object for public APIs
	var supports = !!document.querySelector && !!root.addEventListener; // Feature test
	var settings;

	// Default settings
	var defaults = {
		speed: 500,
		easing: 'easeInOutCubic',
		offset: 0,
		updateURL: false,
		callbackBefore: function () {},
		callbackAfter: function () {}
	};


	//
	// Methods
	//

	/**
	 * A simple forEach() implementation for Arrays, Objects and NodeLists
	 * @private
	 * @param {Array|Object|NodeList} collection Collection of items to iterate
	 * @param {Function} callback Callback function for each iteration
	 * @param {Array|Object|NodeList} scope Object/NodeList/Array that forEach is iterating over (aka `this`)
	 */
	var forEach = function (collection, callback, scope) {
		if (Object.prototype.toString.call(collection) === '[object Object]') {
			for (var prop in collection) {
				if (Object.prototype.hasOwnProperty.call(collection, prop)) {
					callback.call(scope, collection[prop], prop, collection);
				}
			}
		} else {
			for (var i = 0, len = collection.length; i < len; i++) {
				callback.call(scope, collection[i], i, collection);
			}
		}
	};

	/**
	 * Merge defaults with user options
	 * @private
	 * @param {Object} defaults Default settings
	 * @param {Object} options User options
	 * @returns {Object} Merged values of defaults and options
	 */
	var extend = function ( defaults, options ) {
		var extended = {};
		forEach(defaults, function (value, prop) {
			extended[prop] = defaults[prop];
		});
		forEach(options, function (value, prop) {
			extended[prop] = options[prop];
		});
		return extended;
	};

	/**
	 * Calculate the easing pattern
	 * @private
	 * @param {String} type Easing pattern
	 * @param {Number} time Time animation should take to complete
	 * @returns {Number}
	 */
	var easingPattern = function ( type, time ) {
		var pattern;
		if ( type === 'easeInQuad' ) pattern = time * time; // accelerating from zero velocity
		if ( type === 'easeOutQuad' ) pattern = time * (2 - time); // decelerating to zero velocity
		if ( type === 'easeInOutQuad' ) pattern = time < 0.5 ? 2 * time * time : -1 + (4 - 2 * time) * time; // acceleration until halfway, then deceleration
		if ( type === 'easeInCubic' ) pattern = time * time * time; // accelerating from zero velocity
		if ( type === 'easeOutCubic' ) pattern = (--time) * time * time + 1; // decelerating to zero velocity
		if ( type === 'easeInOutCubic' ) pattern = time < 0.5 ? 4 * time * time * time : (time - 1) * (2 * time - 2) * (2 * time - 2) + 1; // acceleration until halfway, then deceleration
		if ( type === 'easeInQuart' ) pattern = time * time * time * time; // accelerating from zero velocity
		if ( type === 'easeOutQuart' ) pattern = 1 - (--time) * time * time * time; // decelerating to zero velocity
		if ( type === 'easeInOutQuart' ) pattern = time < 0.5 ? 8 * time * time * time * time : 1 - 8 * (--time) * time * time * time; // acceleration until halfway, then deceleration
		if ( type === 'easeInQuint' ) pattern = time * time * time * time * time; // accelerating from zero velocity
		if ( type === 'easeOutQuint' ) pattern = 1 + (--time) * time * time * time * time; // decelerating to zero velocity
		if ( type === 'easeInOutQuint' ) pattern = time < 0.5 ? 16 * time * time * time * time * time : 1 + 16 * (--time) * time * time * time * time; // acceleration until halfway, then deceleration
		return pattern || time; // no easing, no acceleration
	};

	/**
	 * Calculate how far to scroll
	 * @private
	 * @param {Element} anchor The anchor element to scroll to
	 * @param {Number} headerHeight Height of a fixed header, if any
	 * @param {Number} offset Number of pixels by which to offset scroll
	 * @returns {Number}
	 */
	var getEndLocation = function ( anchor, headerHeight, offset ) {
		var location = 0;
		if (anchor.offsetParent) {
			do {
				location += anchor.offsetTop;
				anchor = anchor.offsetParent;
			} while (anchor);
		}
		location = location - headerHeight - offset;
		return location >= 0 ? location : 0;
	};

	/**
	 * Determine the document's height
	 * @private
	 * @returns {Number}
	 */
	var getDocumentHeight = function () {
		return Math.max(
			document.body.scrollHeight, document.documentElement.scrollHeight,
			document.body.offsetHeight, document.documentElement.offsetHeight,
			document.body.clientHeight, document.documentElement.clientHeight
		);
	};

	/**
	 * Remove whitespace from a string
	 * @private
	 * @param {String} string
	 * @returns {String}
	 */
	var trim = function ( string ) {
		return string.replace(/^\s+|\s+$/g, '');
	};

	/**
	 * Convert data-options attribute into an object of key/value pairs
	 * @private
	 * @param {String} options Link-specific options as a data attribute string
	 * @returns {Object}
	 */
	var getDataOptions = function ( options ) {
		var settings = {};
		// Create a key/value pair for each setting
		if ( options ) {
			options = options.split(';');
			options.forEach( function(option) {
				option = trim(option);
				if ( option !== '' ) {
					option = option.split(':');
					settings[option[0]] = trim(option[1]);
				}
			});
		}
		return settings;
	};

	/**
	 * Update the URL
	 * @private
	 * @param {Element} anchor The element to scroll to
	 * @param {Boolean} url Whether or not to update the URL history
	 */
	var updateUrl = function ( anchor, url ) {
		if ( history.pushState && (url || url === 'true') ) {
			history.pushState( {
				pos: anchor.id
			}, '', anchor );
		}
	};

	/**
	 * Start/stop the scrolling animation
	 * @public
	 * @param {Element} toggle The element that toggled the scroll event
	 * @param {Element} anchor The element to scroll to
	 * @param {Object} settings
	 * @param {Event} event
	 */
	exports.animateScroll = function ( toggle, anchor, options, event ) {

		// Options and overrides
		var settings = extend( settings || defaults, options || {} );  // Merge user options with defaults
		var overrides = getDataOptions( toggle ? toggle.getAttribute('data-options') : null );
		settings = extend( settings, overrides );

		// Selectors and variables
		var fixedHeader = document.querySelector('[data-scroll-header]'); // Get the fixed header
		var headerHeight = fixedHeader === null ? 0 : (fixedHeader.offsetHeight + fixedHeader.offsetTop); // Get the height of a fixed header if one exists
		var startLocation = root.pageYOffset; // Current location on the page
		var endLocation = getEndLocation( document.querySelector(anchor), headerHeight, parseInt(settings.offset, 10) ); // Scroll to location
		var animationInterval; // interval timer
		var distance = endLocation - startLocation; // distance to travel
		var documentHeight = getDocumentHeight();
		var timeLapsed = 0;
		var percentage, position;

		// Prevent default click event
		if ( toggle && toggle.tagName.toLowerCase() === 'a' && event ) {
			event.preventDefault();
		}

		// Update URL
		updateUrl(anchor, settings.updateURL);

		/**
		 * Stop the scroll animation when it reaches its target (or the bottom/top of page)
		 * @private
		 * @param {Number} position Current position on the page
		 * @param {Number} endLocation Scroll to location
		 * @param {Number} animationInterval How much to scroll on this loop
		 */
		var stopAnimateScroll = function (position, endLocation, animationInterval) {
			var currentLocation = root.pageYOffset;
			if ( position == endLocation || currentLocation == endLocation || ( (root.innerHeight + currentLocation) >= documentHeight ) ) {
				clearInterval(animationInterval);
				settings.callbackAfter( toggle, anchor ); // Run callbacks after animation complete
			}
		};

		/**
		 * Loop scrolling animation
		 * @private
		 */
		var loopAnimateScroll = function () {
			timeLapsed += 16;
			percentage = ( timeLapsed / parseInt(settings.speed, 10) );
			percentage = ( percentage > 1 ) ? 1 : percentage;
			position = startLocation + ( distance * easingPattern(settings.easing, percentage) );
			root.scrollTo( 0, Math.floor(position) );
			stopAnimateScroll(position, endLocation, animationInterval);
		};

		/**
		 * Set interval timer
		 * @private
		 */
		var startAnimateScroll = function () {
			settings.callbackBefore( toggle, anchor ); // Run callbacks before animating scroll
			animationInterval = setInterval(loopAnimateScroll, 16);
		};

		/**
		 * Reset position to fix weird iOS bug
		 * @link https://github.com/cferdinandi/smooth-scroll/issues/45
		 */
		if ( root.pageYOffset === 0 ) {
			root.scrollTo( 0, 0 );
		}

		// Start scrolling animation
		startAnimateScroll();

	};

	/**
	 * Initialize Smooth Scroll
	 * @public
	 * @param {Object} options User settings
	 */
	exports.init = function ( options ) {

		// feature test
		if ( !supports ) return;

		// Selectors and variables
		settings = extend( defaults, options || {} ); // Merge user options with defaults
		var toggles = document.querySelectorAll('[data-scroll]'); // Get smooth scroll toggles

		// When a toggle is clicked, run the click handler
		forEach(toggles, function (toggle) {
			toggle.addEventListener('click', exports.animateScroll.bind( null, toggle, toggle.hash, settings ), false);
		});

	};


	//
	// Public APIs
	//

	return exports;

});

//SmoothScroll v0.9.9
//Licensed under the terms of the MIT license.
//People involved
//- Balazs Galambosi: maintainer (CHANGELOG.txt)
//- Patrick Brunner (patrickb1991@gmail.com)
//- Michael Herf: ssc_pulse Algorithm

function ssc_init() {
if (!document.body) return;
var e = document.body;
var t = document.documentElement;
var n = window.innerHeight;
var r = e.scrollHeight;
ssc_root = document.compatMode.indexOf("CSS") >= 0 ? t : e;
ssc_activeElement = e;
ssc_initdone = true;
if (top != self) {
 ssc_frame = true
} else if (r > n && (e.offsetHeight <= n || t.offsetHeight <= n)) {
 ssc_root.style.height = "auto";
 if (ssc_root.offsetHeight <= n) {
   var i = document.createElement("div");
   i.style.clear = "both";
   e.appendChild(i)
 }
}
if (!ssc_fixedback) {
 e.style.backgroundAttachment = "scroll";
 t.style.backgroundAttachment = "scroll"
}
if (ssc_keyboardsupport) {
 ssc_addEvent("keydown", ssc_keydown)
}
}

function ssc_scrollArray(e, t, n, r) {
r || (r = 1e3);
ssc_directionCheck(t, n);
ssc_que.push({
 x: t,
 y: n,
 lastX: t < 0 ? .99 : -.99,
 lastY: n < 0 ? .99 : -.99,
 start: +(new Date)
});
if (ssc_pending) {
 return
}
var i = function() {
 var s = +(new Date);
 var o = 0;
 var u = 0;
 for (var a = 0; a < ssc_que.length; a++) {
   var f = ssc_que[a];
   var l = s - f.start;
   var c = l >= ssc_animtime;
   var h = c ? 1 : l / ssc_animtime;
   if (ssc_pulseAlgorithm) {
     h = ssc_pulse(h)
   }
   var p = f.x * h - f.lastX >> 0;
   var d = f.y * h - f.lastY >> 0;
   o += p;
   u += d;
   f.lastX += p;
   f.lastY += d;
   if (c) {
     ssc_que.splice(a, 1);
     a--
   }
 }
 if (t) {
   var v = e.scrollLeft;
   e.scrollLeft += o;
   if (o && e.scrollLeft === v) {
     t = 0
   }
 }
 if (n) {
   var m = e.scrollTop;
   e.scrollTop += u;
   if (u && e.scrollTop === m) {
     n = 0
   }
 }
 if (!t && !n) {
   ssc_que = []
 }
 if (ssc_que.length) {
   setTimeout(i, r / ssc_framerate + 1)
 } else {
   ssc_pending = false
 }
};
setTimeout(i, 0);
ssc_pending = true
}

function ssc_wheel(e) {
if (!ssc_initdone) {
 ssc_init()
}
var t = e.target;
var n = ssc_overflowingAncestor(t);
if (!n || e.defaultPrevented || ssc_isNodeName(ssc_activeElement, "embed") || ssc_isNodeName(t, "embed") && /\.pdf/i.test(t.src)) {
 return true
}
var r = e.wheelDeltaX || 0;
var i = e.wheelDeltaY || 0;
if (!r && !i) {
 i = e.wheelDelta || 0
}
if (Math.abs(r) > 1.2) {
 r *= ssc_stepsize / 120
}
if (Math.abs(i) > 1.2) {
 i *= ssc_stepsize / 120
}
ssc_scrollArray(n, -r, -i);
e.preventDefault()
}

function ssc_keydown(e) {
var t = e.target;
var n = e.ctrlKey || e.altKey || e.metaKey;
if (/input|textarea|embed/i.test(t.nodeName) || t.isContentEditable || e.defaultPrevented || n) {
 return true
}
if (ssc_isNodeName(t, "button") && e.keyCode === ssc_key.spacebar) {
 return true
}
var r, i = 0,
   s = 0;
var o = ssc_overflowingAncestor(ssc_activeElement);
var u = o.clientHeight;
if (o == document.body) {
 u = window.innerHeight
}
switch (e.keyCode) {
case ssc_key.up:
 s = -ssc_arrowscroll;
 break;
case ssc_key.down:
 s = ssc_arrowscroll;
 break;
case ssc_key.spacebar:
 r = e.shiftKey ? 1 : -1;
 s = -r * u * .9;
 break;
case ssc_key.pageup:
 s = -u * .9;
 break;
case ssc_key.pagedown:
 s = u * .9;
 break;
case ssc_key.home:
 s = -o.scrollTop;
 break;
case ssc_key.end:
 var a = o.scrollHeight - o.scrollTop - u;
 s = a > 0 ? a + 10 : 0;
 break;
case ssc_key.left:
 i = -ssc_arrowscroll;
 break;
case ssc_key.right:
 i = ssc_arrowscroll;
 break;
default:
 return true
}
ssc_scrollArray(o, i, s);
e.preventDefault()
}

function ssc_mousedown(e) {
ssc_activeElement = e.target
}

function ssc_setCache(e, t) {
for (var n = e.length; n--;) ssc_cache[ssc_uniqueID(e[n])] = t;
return t
}

function ssc_overflowingAncestor(e) {
var t = [];
var n = ssc_root.scrollHeight;
do {
 var r = ssc_cache[ssc_uniqueID(e)];
 if (r) {
   return ssc_setCache(t, r)
 }
 t.push(e);
 if (n === e.scrollHeight) {
   if (!ssc_frame || ssc_root.clientHeight + 10 < n) {
     return ssc_setCache(t, document.body)
   }
 } else if (e.clientHeight + 10 < e.scrollHeight) {
   overflow = getComputedStyle(e, "").getPropertyValue("overflow");
   if (overflow === "scroll" || overflow === "auto") {
     return ssc_setCache(t, e)
   }
 }
} while (e = e.parentNode)
}

function ssc_addEvent(e, t, n) {
window.addEventListener(e, t, n || false)
}

function ssc_removeEvent(e, t, n) {
window.removeEventListener(e, t, n || false)
}

function ssc_isNodeName(e, t) {
return e.nodeName.toLowerCase() === t.toLowerCase()
}

function ssc_directionCheck(e, t) {
e = e > 0 ? 1 : -1;
t = t > 0 ? 1 : -1;
if (ssc_direction.x !== e || ssc_direction.y !== t) {
 ssc_direction.x = e;
 ssc_direction.y = t;
 ssc_que = []
}
}

function ssc_pulse_(e) {
var t, n, r;
e = e * ssc_pulseScale;
if (e < 1) {
 t = e - (1 - Math.exp(-e))
} else {
 n = Math.exp(-1);
 e -= 1;
 r = 1 - Math.exp(-e);
 t = n + r * (1 - n)
}
return t * ssc_pulseNormalize
}

function ssc_pulse(e) {
if (e >= 1) return 1;
if (e <= 0) return 0;
if (ssc_pulseNormalize == 1) {
 ssc_pulseNormalize /= ssc_pulse_(1)
}
return ssc_pulse_(e)
}

var ssc_framerate = 150;
var ssc_animtime = 500;
var ssc_stepsize = 150;
var ssc_pulseAlgorithm = true;
var ssc_pulseScale = 6;
var ssc_pulseNormalize = 1;
var ssc_keyboardsupport = true;
var ssc_arrowscroll = 50;
var ssc_frame = false;
var ssc_direction = {
x: 0,
y: 0
};

var ssc_initdone = false;
var ssc_fixedback = true;
var ssc_root = document.documentElement;
var ssc_activeElement;
var ssc_key = {
left: 37,
up: 38,
right: 39,
down: 40,
spacebar: 32,
pageup: 33,
pagedown: 34,
end: 35,
home: 36
};

var ssc_que = [];
var ssc_pending = false;
var ssc_cache = {};

setInterval(function() {
ssc_cache = {}
}, 10 * 1e3);

var ssc_uniqueID = function() {
var e = 0;
return function(t) {
 return t.ssc_uniqueID || (t.ssc_uniqueID = e++)
}
}();

var ischrome = /chrome/.test(navigator.userAgent.toLowerCase());

if (ischrome) {
ssc_addEvent("mousedown", ssc_mousedown);
ssc_addEvent("mousewheel", ssc_wheel);
ssc_addEvent("load", ssc_init)
}