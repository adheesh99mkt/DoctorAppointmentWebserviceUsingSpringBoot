package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AppointRespDTO;
import com.app.dto.AuthDTO;
import com.app.dto.RegDTO;
import com.app.dto.UpdateDTO;
import com.app.dto.UserRespDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> userLogIn(@RequestBody AuthDTO dto){
		try {
			UserRespDTO respDto=userService.logIn(dto);
			return ResponseEntity.ok(respDto);
		}
		catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	@PostMapping("/register")
	public ApiResponse userSignUp(@RequestBody RegDTO dto) {
		return userService.signUp(dto);
	}
	@GetMapping
	public List<UserRespDTO> listAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable @Valid Long userId) {
		try {
			UserRespDTO user= userService.getUser(userId);
			return ResponseEntity.ok(user);
		}
		catch(RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
		
	}
	@PutMapping
	public ApiResponse updateUser(@RequestBody UpdateDTO dto) {
		return userService.updateUserDetails(dto);
	}
	@PostMapping("/{userId}")
	public List<AppointRespDTO> getAllAppointmentUser(@PathVariable @Valid Long userId){
		return userService.getAllAppointment(userId);
	}
	
}
