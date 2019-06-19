package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * Beetl模板Controller
 * @author zhouhao
 *
 */
@Controller
@RequestMapping("/beetl")
public class BeetlController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/showUserInfo.html")
	public ModelAndView showUserInfo(int id) {
		ModelAndView mav = new ModelAndView("/userInfo.btl");
		User user = userService.queryUserById(id);
		mav.addObject("user", user);
		return mav;
	}
	
	@GetMapping("/user/{id}.json")
	public User showUserInfoJson(@PathVariable int id) {
		return userService.queryUserById(id);
	}
}
