package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;
import com.example.demo.utils.CommUtil;
/**
 * 首页
 * @author zhouhao
 *
 */
@Controller
public class IndexController extends BaseController {
	
	@Autowired
	private UserService userService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	@GetMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/index");
		view.addObject("users", userService.allUserInfo());
		view.addObject("dictionarys", super.dictionaryListByParentName(CommUtil.Property.DICTIONARY_PARENT_NAME_CHARACTER_TYPE));
		return view;
	}
	
	@RequestMapping("/name")
	public @ResponseBody String getName(@RequestParam("name") String name) {
		return "Hello " + name;
	}
	
	@RequestMapping("/date")
	public @ResponseBody String getDate(@RequestParam("date") Date date) {
		return "您的生日 " + date;
	}
}
