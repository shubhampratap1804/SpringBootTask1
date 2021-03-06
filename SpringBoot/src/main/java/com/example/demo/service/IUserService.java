package com.example.demo.service;

import java.util.List;
import com.example.demo.Model.UserModel;
import com.example.demo.dto.UserDTO;

public interface IUserService {
	
	List<UserModel> getAllUsersDetails();
	
	UserModel addUserDetails(UserDTO userDTO);
	
	UserModel updateUserDetails(int id, UserDTO userDTO);
	
	void deleteUserDetails(int id);
	
	UserModel getUserDetailsById(int id);

}
