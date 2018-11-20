package com.srm.web.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.srm.web")
public class ExceptionHandler 
{
	@ExceptionHandler
	public ModelAndView handleException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
}
