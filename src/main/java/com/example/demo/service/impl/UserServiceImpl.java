package com.example.demo.service.impl;

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
	
	private User user;

	@Override
	public List<User> allUserInfo() {
		return userDao.findAll();
	}

	@Override
	public User queryUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional
	public boolean addUserInfo(UserForm userForm) {
		user = new User();
		BeanUtils.copyProperties(userForm, user);
		return true;
	}

	@Override
	@Transactional
	public boolean updateUserInfo(UserForm userForm) {
		user = new User();
		BeanUtils.copyProperties(userForm, user);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUserInfo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
