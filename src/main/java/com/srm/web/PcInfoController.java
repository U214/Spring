package com.srm.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.srm.domain.PcInfoVO;
import com.srm.service.impl.PcInfoServiceImpl;

@Controller
public class PcInfoController {
	@Autowired
	private PcInfoServiceImpl pcInfoService;
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.toString());
		mav.setViewName("error");
		return mav;
	}
	
	// 서버 등록
	@RequestMapping(value= "/regserver", method=RequestMethod.POST)
	public ModelAndView registerServer(
			@Valid PcInfoVO pcInfo,
			ModelAndView mav,
			HttpSession session) throws Exception 
	{
		pcInfo.setEmail((String)session.getAttribute("email"));
		System.out.println(pcInfo.toString());
		
		pcInfoService.insertUser(pcInfo);
		
		mav.setViewName("index");
		return mav;
	}
	
}
