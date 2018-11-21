package com.srm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srm.domain.UserVO;
import com.srm.service.impl.UserServiceImpl;
import com.srm.util.Encryption;

@Controller
public class UserController {
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView loginView(
			HttpServletRequest request,
			ModelAndView mav,
			Encryption encryption) throws Exception 
	{
		encryption.createKeyRSA(request);
		
		mav.addObject("publicKeyModulus", request.getAttribute("publicKeyModulus"));
		mav.addObject("publicKeyExponent", request.getAttribute("publicKeyExponent"));
		mav.setViewName("login");
		return mav;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@ModelAttribute @Valid UserVO vo,
			BindingResult bindingResult,
			UserServiceImpl service, 
			Encryption encryption,
			HttpServletRequest request,
			HttpSession session) throws Exception 
	{
		encryption.decryptToRSA(request);
		vo.setPassword(encryption.encryptToSha512((String)request.getAttribute("username")));
		
		service.loginCheck(vo);
		
		return "main";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
}
