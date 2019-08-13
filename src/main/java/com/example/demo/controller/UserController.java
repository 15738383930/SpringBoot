package com.example.demo.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.example.demo.utils.CommUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;

/**
 * 用户控制器
 * @author zhouhao
 *
 */
@RestController
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * 查询用户信息集合
	 * @return
	 */
	@GetMapping("/list/*.json")
	public Result listUser() {
		try {
			return Result.ok(userService.allUserInfo(),"查询用户信息集合成功！");
		} catch (Exception e) {
			log.info("查询用户信息集合失败！{}", e);
			return Result.fail("查询用户信息集合失败！");
		}
	}
	
	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}.json")
	public Result getUserId(@PathVariable int id) {
		try {
			if(id <= 0) {
				log.error("查询用户信息失败！用户id不能为空。");
				return Result.fail("系统异常！请刷新后再试。");
			}
			return Result.ok(userService.queryUserById(id),"查询用户信息集合成功！");
		} catch (Exception e) {
			log.info("查询用户信息失败！用户id：{}。=====异常信息：{}", id, e);
			return Result.fail("查询用户信息集合失败！");
		}
	}
	
	/**
	 * 新增用户信息
	 * @param userForm 新增用户的form表单
	 * @param result 验证结果
	 * @return
	 */
	@PostMapping("/saveResult.json")
	public Result saveUser(@Validated({UserForm.Add.class}) UserForm userForm, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			FieldError error = (FieldError)list.get(0);
			System.out.println(error.getObjectName()+","+error.getField()+  ","+error.getDefaultMessage());
			log.error("【新增用户】===表单数据有误。");
			return Result.fail(error.getField(), error.getDefaultMessage());
		}
		try {
			// 上传图片
			userForm.setPortrait(CommUtil.Method.uploadImage(userForm.getPortraitFile()));
			if(userService.addUserInfo(userForm)) {
				return Result.ok("新增用户信息成功！");
			}
		} catch (Exception e) {
			log.info("【新增用户】===新增用户信息失败！=====异常信息：{}", e);
		}
		return Result.fail("新增用户信息失败！");
	}
	
	/**
	 * 修改用户信息
	 * @param userForm 新增用户的form表单
	 * @param result 验证结果
	 * @return
	 */
	@GetMapping("/editResult.json")
	public Result editUser(@Validated({UserForm.Update.class}) UserForm userForm,BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			FieldError error = (FieldError)list.get(0);
			System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
			log.error("【编辑用户】===表单数据格式有误。");
			return Result.fail("编辑用户信息失败！请刷新后再试。");
		}
		try {
			if(userService.updateUserInfo(userForm)) {
				return Result.ok("编辑用户信息成功！");
			}
		} catch (Exception e) {
			return Result.fail("编辑用户信息失败！");
		}
		return Result.fail("编辑用户信息失败！");
	}
	
	@GetMapping("/45.json")
	public String delUser(@PathVariable int id) {
		return "您的用户编号为"+id;
	}

}
