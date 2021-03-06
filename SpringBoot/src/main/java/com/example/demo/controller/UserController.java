package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.UserModel;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	IUserService iUserService;

	@GetMapping(value = "/get")
	public ResponseEntity<ResponseDTO> getAllUserDetails() {
		List<UserModel> usersDetailsList = null;
		usersDetailsList = iUserService.getAllUsersDetails();
		ResponseDTO responseDTO = new ResponseDTO("Get all users call successful!", usersDetailsList);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<ResponseDTO> getUserContactDetailsById(@PathVariable("userId") int id) {
		UserModel userModel = iUserService.getUserDetailsById(id);
		ResponseDTO responseDTO = new ResponseDTO("Get call for user id is successful!", userModel);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody UserDTO userDTO) {
		UserModel userModel = iUserService.addUserDetails(userDTO);
		ResponseDTO responseDTO = new ResponseDTO("Added user data successfully!", userModel);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<ResponseDTO> updateUserDetailsById(@PathVariable("userId") int id,
			@Valid @RequestBody UserDTO userDTO) {
		UserModel userModel = iUserService.updateUserDetails(id, userDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated user details data successfully!", userModel);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ResponseDTO> deleteUserDetailsDataById(@PathVariable("userId") int id) {
		iUserService.deleteUserDetails(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted user details data successfully!", "Deleted for id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}
