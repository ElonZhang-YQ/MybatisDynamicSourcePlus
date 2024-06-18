package com.ez.mybatisdynamicsourceplus.service;

import com.ez.mybatisdynamicsourceplus.bean.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
public interface UserService {

	List<User> findAllUsers();

}
