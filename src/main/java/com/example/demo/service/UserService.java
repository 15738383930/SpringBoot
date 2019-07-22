package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;

/**
 * 用户业务接口
 * @author zhouhao
 *
 */
public interface UserService {

	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> allUserInfo();

	/**
	 * 根据条件检索用户信息
	 * @param user
	 * @return
	 */
	List<User> userSearch(User user);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User queryUserById(int id);
	
	/**
	 * 添加用户信息
	 * @param userForm
	 * @return
	 */
	boolean addUserInfo(UserForm userForm);

	/**
	 * 修改用户信息
	 * @param userForm
	 * @return
	 */
	boolean updateUserInfo(UserForm userForm);

	/**
	 * 删除用户信息（伪删除）
	 * @param user
	 * @return
	 */
	boolean deleteUserInfo(User user);
}
