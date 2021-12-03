package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.UserModel;
import com.example.demo.dto.UserDTO;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserModel> getAllUsersDetails() {
		return userRepository.findAll();
	}

	@Override
	public UserModel addUserDetails(UserDTO userDTO) {
		UserModel userModel = null;
		userModel = new UserModel(userDTO);
		return userRepository.save(userModel);
	}

	@Override
	public UserModel updateUserDetails(int id, UserDTO userDTO) {
		UserModel userModel = this.getUserDetailsById(id);
		userModel.updateUserData(userDTO);
		return userRepository.save(userModel);
	}

	@Override
	public void deleteUserDetails(int id) {
		UserModel userModel = this.getUserDetailsById(id);
		userRepository.delete(userModel);

	}

	@Override
	public UserModel getUserDetailsById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserException("User with this id " + id + "doest not exists!"));
	}
}
