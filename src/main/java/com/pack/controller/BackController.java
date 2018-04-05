package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackController {
    @Autowired
    UserDaoImpl dao;
	@RequestMapping(value="/Regd",method=RequestMethod.GET)
	public ModelAndView m1(){
	 ModelAndView mav=new ModelAndView("register");	
	 return mav;
	}
	@RequestMapping(value="/process",method=RequestMethod.POST)
	public ModelAndView m2(@ModelAttribute("user") User user){
	 dao.register(user);
     ModelAndView mav1=new ModelAndView("success1");
     mav1.addObject("name",user.getUsername());
	 return mav1;
	}
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public ModelAndView m3(){
     ModelAndView mav2=new ModelAndView("login");
	 return mav2;
	}
	@RequestMapping(value="/Success",method=RequestMethod.POST)
	public ModelAndView m4(@ModelAttribute("login1") Login login1){	
	 ModelAndView mav5=null;
	 User list=dao.validateUser(login1);
	 if(list!= null){
		mav5=new ModelAndView("success");
		mav5.addObject("name",list.getUsername());
	 }
	 else{
     mav5=new ModelAndView("login");
	}
	return mav5; 
}
}
