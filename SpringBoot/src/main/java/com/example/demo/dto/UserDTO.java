package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDTO {

	public String name;
	public String email;
	public String password;
	public String mobile;
	public String address;

	public UserDTO(String name, String email, String password, String mobile, String address) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}

}
