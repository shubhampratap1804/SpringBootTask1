package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.UserDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "usertable")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String address;

	public UserModel() {
	}

	public UserModel(UserDTO userDTO) {
		this.updateUserData(userDTO);
	}

	public void updateUserData(UserDTO userDTO) {
		this.name = userDTO.name;
		this.email = userDTO.email;
		this.password = userDTO.password;
		this.mobile = userDTO.mobile;
		this.address = userDTO.address;
	}

}
