package com.example.demo.controller;

import java.util.Date;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

	@GetMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/index");
		view.addObject("users", userService.allUserInfo());
		view.addObject("dictionarys", super.dictionaryListByParentName(CommUtil.Property.DICTIONARY_PARENT_NAME_CHARACTER_TYPE));
		return view;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView getName(User user) {
        ModelAndView view = new ModelAndView("/index");
        // 数据回显
		view.addObject("echo", user);
		// 查询结果
        view.addObject("users", userService.userSearch(user));
        view.addObject("dictionarys", super.dictionaryListByParentName(CommUtil.Property.DICTIONARY_PARENT_NAME_CHARACTER_TYPE));
        return view;
	}
	
	@RequestMapping("/date")
	public @ResponseBody String getDate(@RequestParam("date") Date date) {
		return "您的生日 " + date;
	}
}
