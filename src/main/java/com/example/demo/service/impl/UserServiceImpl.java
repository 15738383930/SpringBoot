package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo.utils.CommUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;
import org.springframework.util.StringUtils;

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
		// 根据age、id依次倒序排序
		Sort sort = new Sort(Sort.Direction.DESC, "age", "id");
		return userDao.findAll(sort);
	}

	@Override
	public List<User> userSearch(User user) {
		ExampleMatcher em = ExampleMatcher.matching()
				.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
				.withIgnorePaths("id");
		Example e = Example.of(user, em);
		return userDao.findAll(e);
	}

	@Override
	public User queryUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean addUserInfo(UserForm userForm) throws IOException {
		// 上传图片
		userForm.setPortrait(CommUtil.Method.uploadImage(userForm.getPortraitFile()));
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		user = userDao.saveAndFlush(user);
		if(user != null){
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateUserInfo(UserForm userForm) throws IOException {
		User user = userDao.findById(userForm.getId());
		// 上传图片
		userForm.setPortrait(CommUtil.Method.uploadImage(user.getPortrait(), userForm.getPortraitFile()));
		CommUtil.Method.copyPropertiesIgnoreNull(userForm, user);
		userDao.saveAndFlush(user);
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteUserInfo(User user) {
		return false;
	}

}
