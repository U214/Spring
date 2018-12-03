<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- index.jsp start -->
<header id="home">
	<div class="main-nav">

		<!-- 로그인, 회원가입, 비번찾기 -->
		<div class="cd-user-modal">
			<div class="cd-user-modal-container">
				<!-- 로그인 -->
				<div id="cd-login">
					<form class="cd-form">
						<p class="fieldset">
							<label class="image-replace cd-username" for="signin-id">E-mail</label>
							<input class="full-width has-padding has-border" name="email"
								id="signin_email" type="email" placeholder="E-mail">
							<!-- <span class="cd-error-message">[Error]::   입력 해 주세요</span> -->
						</p>
						<p class="fieldset">
							<label class="image-replace cd-password" for="signin-password">Password</label>
							<input class="full-width has-padding has-border" name="pw"
								id="signin_password" type="password" placeholder="Password">
							<a href="#0" class="hide-password">Show</a>
							<!-- <span class="cd-error-message">[Error]::   입력 해 주세요</span> -->
						</p>
						<a href="./loginFailure.jsp" onclick="validateEncryptedForm('login'); return false;"> 
							<input class="full-width" type="submit" value="Login">
						</a>	
	
						<span class="cd-form-bottom-message">
							<a id="signup">계정이 없으신가요?</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a id="forgotpw">비밀번호 찾기</a>
						</span>
					</form>
				</div>
	
				<!-- 회원가입 -->
				<div id="cd-signup">
				<form class="cd-form">
					<p class="fieldset">
						<label class="image-replace cd-username" for="signup-username">Username</label>
						<input class="full-width has-padding has-border" name="name"
							id="signup_username" type="text" placeholder="Username">
					</p>

					<p class="fieldset">
						<label class="image-replace cd-email" for="signup-email">E-mail</label>
						<input class="full-width has-padding has-border" name="email"
							id="signup_email" type="email" placeholder="E-mail">
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signup-password">Password</label>
						<input class="full-width has-padding has-border" name="pw"
							id="signup_password" type="password" placeholder="Password">
						<a href="#0" class="hide-password">Show</a>
					</p>
					<p class="fieldset">
					<a href="./loginFailure.jsp" onclick="validateEncryptedForm('join'); return false;"> 
						<input class="full-width has-padding" type="submit" value="Sign Up">
					</a>
					</p>
				</form>
				</div>
	
				<!-- 비번찾기 -->
				<div id="cd-reset-password">
					<p class="cd-form-message">비밀번호를 찾으시려면 기입 해 주세요.</p>
						<form class="cd-form" action="./find/findPWP.jsp">
							<p class="fieldset">
								<label class="image-replace cd-email" for="reset-email">E-mail</label>
								<input class="full-width has-padding has-border" name="email" id="reset-email" type="email" placeholder="E-mail">
								<!-- <span class="cd-error-message">[Error]::   입력 해 주세요</span> -->
							</p>
							<p class="fieldset">
								<input class="full-width has-padding" type="submit" value="비밀번호 재발급 받기">
							</p>
						</form>
					<p class="cd-form-bottom-message">
							<a href="#0">로그인으로 돌아가기</a>
						</p>
				</div>
				
				<!-- 닫기버튼, 히든폼 -->
				<div>
					<p class="fieldset">
						<input type="hidden" id="rsaPublicKeyModulus" value="${publicKeyModulus}" /> 
						<input type="hidden" id="rsaPublicKeyExponent" value="${publicKeyExponent}" />
						<form id="securedindex" name="securedindex" action="${contextPath}/" method="post" style="display: none;">
							<input type="hidden" name="securedEmail" id="securedEmail" value="" /> 
							<input type="hidden" name="securedPassword" id="securedPassword" value="" />
						</form>
					
					<a href="#0" class="cd-close-form">Close</a>
				</div>
			</div>
		</div>
	</div>
	
	<div id="home-slider" class="carousel slide carousel-fade"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="item active" style="background-image: url(images/slider/s1.png)">
				<div class="caption">
					<h1 class="animated fadeInLeftBig">
						SRM의 강력한<span>실시간 모니터링</span>기능
					</h1>

					<a data-scroll class="btn btn-start animated fadeInUpBig" href="#services">Start now</a>
				</div>
			</div>
			<div class="item" style="background-image: url(images/slider/s2.png)">

				<div class="caption">
					<div class="img-item">
						<img alt="" src="images/slider/srm.png">
					</div>
					<h1 class="animated fadeInLeftBig">
						SRM의<span>원격 제어</span>기능
					</h1>
					<p class="animated fadeInRightBig">쉽고 간편한 원격 제어 서비스</p>
					<a data-scroll class="btn btn-start animated fadeInUpBig"
						href="#services">Start now</a>
				</div>
			</div>
			<div class="item" style="background-image: url(images/slider/s3.png)">
				<div class="caption">
					<div class="img-item2">
						<img alt="" src="images/slider/fee.png">
					</div>
					<h1 class="animated fadeInLeftBig">
						SRM의 <span>무료</span>서비스
					</h1>
					<p class="animated fadeInRightBig">이 모든 기능을 무료로 사용하세요!</p>
					<a data-scroll class="btn btn-start animated fadeInUpBig"
						href="#services">Start now</a>
				</div>
			</div>
		</div>
		<a class="left-control" href="#home-slider" data-slide="prev"><i
			class="fa fa-angle-left"></i></a> <a class="right-control"
			href="#home-slider" data-slide="next"><i
			class="fa fa-angle-right"></i></a> <a id="tohash" href="#services"><i
			class="fa fa-angle-down"></i></a>

	</div>
	<!--/#home-slider-->

	<div class="main-nav">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>

				<a class="navbar-brand">
					<h1><img src="images/sclogo.png"></h1>
				</a> 
				<a class="navbar-brand" href="${contextPath}/">
					<h2><img class="img-responsive" src="images/logo.png" alt="logo"></h2>
				</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="scroll active"><a href="#home">Home</a></li>
					<li class="scroll"><a href="#services">Service</a></li>
					<li class="scroll"><a href="#team">Team</a></li>
					<li class="scroll"><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--/#main-nav--> 
	
	</header>
	<!--/#home-->
	
	<section id="services">
	<div class="container">
		<div class="heading wow fadeInUp" data-wow-duration="1000ms"
			data-wow-delay="300ms">
			<div class="row">
				<div class="text-center col-sm-8 col-sm-offset-2">
					<h2>Our Services</h2>
					<h4>
						<b>서비스전, 아래 설치 파일을 받아주세요.</b>
					</h4>
					<div class="main-nav"></div>

				</div>
			</div>
		</div>
		<div class="text-center our-services">
			<div class="row">
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms"
					data-wow-delay="300ms" onclick="location='./down/downZIP.jsp'">
					<div class="service-icon">
						<p>
						<p>
							<i class="fa fa-bar-chart"></i>
					</div>
					<div class="service-info">
						<h3>
							<b>SRM.zip</b>
						</h3>
						<h5>클라이언트용 설치파일</h5>
					</div>
				</div>
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms"
					data-wow-delay="450ms" onclick="location='./down/downPPT.jsp'">
					<div class="service-icon">
						<p>
						<p>
							<i class="fa fa-list-alt"></i>
					</div>
					<div class="service-info">
						<h3>
							<b>SRM.pptx</b>
						</h3>
						<h5>프로그램 소개 PPT</h5>
					</div>
				</div>
				<div class="col-sm-4 wow fadeInDown" data-wow-duration="1000ms"
					data-wow-delay="550ms"
					onclick="window.open('https://chrome.google.com/webstore/detail/ie-tab/hehijbfgiekmjfkfjpbkbammjbdenadd?hl=ko', '_blank')">
					<div class="service-icon">
						<p>
						<p>
							<i class="fa fa-internet-explorer"></i>
					</div>
					<div class="service-info">
						<h3>
							<b>IE tab</b>
						</h3>
						<h5>IE tab 설치</h5>
					</div>
				</div>


			</div>
		</div>
	</div>
	</section>
	<!--/#services-->
	<section id="team">
	<div class="container">
		<div class="row">
			<div
				class="heading text-center col-sm-8 col-sm-offset-2 wow fadeInUp"
				data-wow-duration="1200ms" data-wow-delay="300ms">
				<h2>W.W.W Team을 소개합니다.</h2>
			</div>
		</div>
		<div class="team-members">
			<div class="row">
				<div class="col-sm-3">
					<div class="team-member wow flipInY" data-wow-duration="1000ms"
						data-wow-delay="300ms">
						<div class="member-image">
							<img class="img-responsive" src="images/team/su.png" alt="">
						</div>
						<div class="member-info">
							<h3>
								<b>이 상 윤</b>
							</h3>
							<h4>조 장</h4>

							<li><i class="fa fa-envelope"></i> <span> Email:</span><a
								href="mailto:someone@yoursite.com">power10267@naver.com</a></li>
						</div>
						<div class="social-icons">
							<ul>

								<li><a class="facebook" href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li><a class="twitter" href="#"><i
										class="fa fa-twitter"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member wow flipInY" data-wow-duration="1000ms"
						data-wow-delay="500ms">
						<div class="member-image">
							<img class="img-responsive" src="images/team/so.png" alt="">
						</div>
						<div class="member-info">
							<h3>
								<b>박 소 린</b>
							</h3>
							<h4>조 원</h4>

							<li><i class="fa fa-envelope"></i> <span> Email:</span><a
								href="mailto:someone@yoursite.com">soso9430@naver.com</a></li>
						</div>
						<div class="social-icons">
							<ul>
								<li><a class="facebook" href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li><a class="twitter" href="#"><i
										class="fa fa-twitter"></i></a></li>

							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member wow flipInY" data-wow-duration="1000ms"
						data-wow-delay="800ms">
						<div class="member-image">
							<img class="img-responsive" src="images/team/lee.png" alt="">
						</div>
						<div class="member-info">
							<h3>
								<b>최 수 지</b>
							</h3>
							<h4>조 원</h4>

							<li><i class="fa fa-envelope"></i> <span> Email:</span><a
								href="mailto:someone@yoursite.com">queenc0222naver.com</a></li>
							<p></p>
						</div>
						<div class="social-icons">
							<ul>
								<li><a class="facebook" href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li><a class="twitter" href="#"><i
										class="fa fa-twitter"></i></a></li>


							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="team-member wow flipInY" data-wow-duration="1000ms"
						data-wow-delay="1100ms">
						<div class="member-image">
							<img class="img-responsive" src="images/team/window.png" alt="">
						</div>
						<div class="member-info">
							<h3>
								<b>유 리 나</b>
							</h3>
							<h4>조 원</h4>

							<li><i class="fa fa-envelope"></i> <br><span> Email:</span><a
								href="mailto:someone@yoursite.com">snrnsl2naver.com</a></li>
							<p></p>
						</div>
						<div class="social-icons">
							<ul>
								<li><a class="facebook" href="#"><i
										class="fa fa-facebook"></i></a></li>
								<li><a class="twitter" href="#"><i
										class="fa fa-twitter"></i></a></li>


							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-3">
				<div class="team-member wow flipInY" data-wow-duration="1000ms"
					data-wow-delay="1100ms">
					<div class="member-image">
						<img class="img-responsive" src="images/team/you.png" alt="">
					</div>
					<div class="member-info">
						<h3>
							<b>서 유 정</b>
						</h3>
						<h4>조 원</h4>

						<li><i class="fa fa-envelope"></i> <span> Email:</span><a
							href="mailto:someone@yoursite.com">dbwjd7265@naver.com</a></li>
						<p></p>
					</div>
					<div class="social-icons">
						<ul>
							<li><a class="facebook" href="#"><i
									class="fa fa-facebook"></i></a></li>
							<li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>


						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>

	</section>
	<!--/#team-->

	<section id="contact">
	<div id="google-map" class="wow fadeIn" data-latitude="37.714393"
		data-longitude="126.889897" data-wow-duration="1000ms"
		data-wow-delay="400ms"></div>
	<div id="contact-us" class="parallax">
		<div class="container">
			<div class="row">
				<div
					class="heading text-center col-sm-8 col-sm-offset-2 wow fadeInUp"
					data-wow-duration="1000ms" data-wow-delay="300ms">
					<h2>고객 상담</h2>
					<p>오류가 발생했거나, 기타 문의사항이 있을 시 이쪽 주소로 우편 혹은 연락 해 주세요. 감사합니다.</p>
				</div>
			</div>
			<div class="contact-form wow fadeIn" data-wow-duration="1000ms"
				data-wow-delay="600ms">
				<div class="row">

					<div class="col-sm-6">

						<ul class="address">
							<li><i class="fa fa-map-marker"></i> <span> Address:</span>
								경기도 고양시 덕양구 동헌로 305 세종관 833호</li>

							<li><i class="fa fa-globe"></i> <span> 본교 홈페이지:</span> <a
								href="http://www.joongbu.ac.kr/">www.joongbu.ac.kr</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>

	</section>
	<!--/#contact-->

	<footer id="footer">
	<div class="footer-top wow fadeInUp" data-wow-duration="1000ms"
		data-wow-delay="300ms">
		<div class="container text-center">
			<div class="footer-logo">
				<a href="./index.jsp"><img class="img-responsive"
					src="images/logo.png" alt=""></a>
			</div>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<p>2016년 중부대학교 정보보호학과 졸업작품 2조</p>
				</div>

			</div>
		</div>
	</div>
	</footer>
<!-- index.jsp end -->