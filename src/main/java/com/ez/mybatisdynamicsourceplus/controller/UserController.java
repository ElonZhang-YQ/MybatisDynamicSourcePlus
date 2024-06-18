package com.ez.mybatisdynamicsourceplus.controller;

import com.ez.mybatisdynamicsourceplus.bean.User;
import com.ez.mybatisdynamicsourceplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/showAll")
	public List<User> showAllUsers() {

		return userService.findAllUsers();
	}
}
