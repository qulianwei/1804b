package com.jk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	//登录成功的页面
	@RequestMapping("/admin/home")
	public String adminHomePage(){
		return "view/mainPage";
	}

}
