package com.ez.mybatisdynamicsourceplus.mapper;

import com.ez.mybatisdynamicsourceplus.annotation.DataSource;
import com.ez.mybatisdynamicsourceplus.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname MasterUserMapper
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
public interface UserMapper {

	@DataSource("Slave")
	@Select("SELECT id,username,password FROM user")
	List<User> selectAllUser();

}
