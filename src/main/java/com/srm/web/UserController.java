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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.srm.domain.UserVO;
import com.srm.service.impl.UserServiceImpl;
import com.srm.util.Encryption;

@Controller
public class UserController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}
	
	// 인덱스 메인화면
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public ModelAndView indexView(ModelAndView mav) throws Exception 
	{
		mav.setViewName("index");
		return mav;
	}
	
	// 로그인 & 회원가입 화면
	@RequestMapping(value= {"/signinandup"}, method=RequestMethod.GET)
	public ModelAndView signInUpView(
			HttpServletRequest request,
			ModelAndView mav,
			Encryption encryption) throws Exception 
	{
		// 암호화 시킬 rsa키를 만든다
		encryption.createKeyRSA(request);
		
		mav.addObject("publicKeyModulus", request.getAttribute("publicKeyModulus"));
		mav.addObject("publicKeyExponent", request.getAttribute("publicKeyExponent"));
		mav.setViewName("index");
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
		
		service.checkLogin(vo);
		
		return "main";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute @Valid UserVO vo,
			BindingResult bindingResult,
			UserServiceImpl service, 
			Encryption encryption,
			HttpServletRequest request) throws Exception 
	{
		encryption.decryptToRSA(request);
		vo.setPassword(encryption.encryptToSha512((String)request.getAttribute("username")));
		
		service.insertUser(vo);
		
		return "redirect:/";
	}
	
	
	// 아이디 중복확인 ajax 메서드
	@RequestMapping(value= "/checkjoinid.ajax", method=RequestMethod.GET)
	public @ResponseBody boolean CheckJoinID(  
	        @RequestParam("id") String id,
	        UserVO vo,
	        UserServiceImpl service) throws Exception  
	{
		vo.setId(id);
		return service.checkId(vo);
	}
}
