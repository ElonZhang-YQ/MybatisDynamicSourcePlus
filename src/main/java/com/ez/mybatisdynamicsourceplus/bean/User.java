package com.ez.mybatisdynamicsourceplus.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Classname User
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	private Long id;

	private String username;

	private String password;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, username, password);
	}

	@Override
	public String toString() {

		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
