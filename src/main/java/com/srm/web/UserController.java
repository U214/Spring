package com.srm.web;

import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private UserServiceImpl service;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.toString());
		mav.setViewName("error");
		return mav;
	}
	
	// 인덱스 메인화면
	@RequestMapping(value= "/", method=RequestMethod.GET)
	public ModelAndView indexView(ModelAndView mav) throws Exception 
	{
		mav.setViewName("index");
		return mav;
	}
	
	// 로그인 화면
	@RequestMapping(value= {"/login"}, method=RequestMethod.GET)
	public ModelAndView loginView(
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
	
	// 로그인 인증
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@RequestParam(value="securedEmail") String email,
			@RequestParam(value="securedPassword") String password,
			@Valid UserVO vo,
			BindingResult bindingResult,
			Encryption encryption,
			HttpServletRequest request) throws Exception 
	{
		HttpSession session = request.getSession();
		PrivateKey key = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
		
		vo.setEmail(encryption.decryptToRSA(key, email));
		vo.setPassword(encryption.encryptToSha512(encryption.decryptToRSA(key, password)));
		
		service.checkLogin(vo);
		
		return "main";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(
			@RequestParam(value="securedEmail") String email,
			@RequestParam(value="securedPassword") String password,
			@RequestParam(value="username") String username,
			@Valid UserVO vo,
			BindingResult bindingResult,
			Encryption encryption,
			HttpServletRequest request) throws Exception 
	{
		HttpSession session = request.getSession();
		PrivateKey key = (PrivateKey) session.getAttribute("__rsaPrivateKey__");
		
		vo.setEmail(encryption.decryptToRSA(key, email));
		vo.setPassword(encryption.encryptToSha512(encryption.decryptToRSA(key, password)));
		vo.setName(username);
		
		System.out.println(vo.toString());
		session.removeAttribute("__rsaPrivateKey__");
		
		service.insertUser(vo);
		
		return "redirect:/";
	}
	
	
	// 아이디 중복확인 ajax 메서드
	@RequestMapping(value= "/checkjoinid.ajax", method=RequestMethod.GET)
	public @ResponseBody boolean CheckJoinID(  
	        @RequestParam("id") String id,
	        UserVO vo) throws Exception  
	{
		vo.setEmail(id);
		return service.checkId(vo);
	}
}

/*
 	스프링 MVC 자동 설정 목록
 	- ContentNegotiatingViewResolver 및 BeanNameViewResolver 빈 포함
 	- WebJars 지원을 포함, 정적 자원의 제공을 지원
 	- Converter, GenericConverter 및 Formatter Bean의 자동 등록
 	- HttpMessageConverters 지원
 	- MessageCodesResolver 자동 등록
    - 정적 index.html 지원.
    - ConfigurableWebBindingInitializer Bean의 자동 사용
    
    개인적으로 기능을 더 추가하고 싶은 경우
    @Configuration 클래스를 사용
 */
