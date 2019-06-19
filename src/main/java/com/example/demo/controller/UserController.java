package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;

@RestController
@RequestMapping("/user")
@SuppressWarnings("rawtypes")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 查询用户信息集合
	 * @param id
	 * @return
	 */
	@GetMapping("/list/*.json")
	public Result listUser() {
		//return Result.ok(userService.allUserInfo(),"查询用户信息集合成功！");
		return Result.ok();
	}
	
	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}.json")
	public Result getUserId(@PathVariable int id) {
		return Result.ok(userService.queryUserById(id),"查询用户信息集合成功！");
	}
	
	/**
	 * 新增用户信息
	 * @param userForm 新增用户的form表单
	 * @param result 验证结果
	 * @return
	 */
	@PostMapping("/12.json")
	public Result saveUser(@Validated({UserForm.Add.class}) UserForm userForm,BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			FieldError error = (FieldError)list.get(0);
			System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
			return Result.fail("新增用户信息失败！");
		}
		if(userService.addUserInfo(userForm)) {
			return Result.ok("新增用户信息成功！");
		}
		return Result.fail("新增用户信息失败！");
	}
	
	@GetMapping("/23.json")
	public Result editUser(User user) {
		if(userService.updateUserInfo(user)) {
			return Result.ok();
		}
		return Result.fail("编辑用户信息失败！");
	}
	
	@GetMapping("/45.json")
	public String delUser(@PathVariable int id) {
		return "您的用户编号为"+id;
	}

}
