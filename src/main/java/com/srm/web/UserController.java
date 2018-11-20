package com.srm.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.srm.domain.UserVO;
import com.srm.service.impl.UserServiceImpl;
import com.srm.util.Encryption;

@RestController
public class UserController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(HttpServletRequest request, Encryption ec)
	{
		try {
			ec.createKeyRSA(request);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login.jsp";
	}
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(
			@ModelAttribute @Valid UserVO vo,
			BindingResult bindingResult,
			UserServiceImpl service, 
			Encryption ec,
			HttpServletRequest request,
			HttpSession session)
	{
		ec.decryptToRSA(request);
		vo.setPassword(ec.encryptToSha512((String)request.getAttribute("username")));
		
		service.loginCheck(vo);
		
		return "main.do";
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
