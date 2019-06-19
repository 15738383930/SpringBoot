package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * Freemarker模板Controller
 * @author zhouhao
 *
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/showUserInfo.html")
	public ModelAndView showUserInfo(int id) {
		ModelAndView mav = new ModelAndView("/userInfo");
		User user = userService.queryUserById(id);
		mav.addObject("user", user);
		return mav;
	}
}
