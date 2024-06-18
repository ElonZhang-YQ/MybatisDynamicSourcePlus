package com.ez.mybatisdynamicsourceplus.service;

import com.ez.mybatisdynamicsourceplus.bean.User;
import com.ez.mybatisdynamicsourceplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUsers() {

		return userMapper.selectAllUser();
	}
}
