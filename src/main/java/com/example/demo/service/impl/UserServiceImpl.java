package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

/**
 * 用户业务实现层
 * @author zhouhao
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userDao;

	@Override
	public List<User> allUserInfo() {
		return userDao.findAll();
	}

	@Override
	public List<User> userSearch(User user) {
		boolean flag = false;
		/*User.setUser(user) ;
		if (null != user) {
			if (user.getName())
				Arrays.stream()
		} else {
		}
		if (flag) {
			USERS = allUserInfo();
		}*/
		return User.getUsers();
	}

	@Override
	public User queryUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public boolean addUserInfo(UserForm userForm) {
		BeanUtils.copyProperties(userForm, User.getUser());
		return true;
	}

	@Override
	@Transactional
	public boolean updateUserInfo(UserForm userForm) {
		BeanUtils.copyProperties(userForm, User.getUser());
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUserInfo(User user) {
		return false;
	}

}
