package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/**
 * 用户持久层
 * @author zhouhao
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findById(Integer id);
}
