package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.AppointRespDTO;
import com.app.dto.AuthDTO;
import com.app.dto.RegDTO;
import com.app.dto.UpdateDTO;
import com.app.dto.UserRespDTO;
import com.app.entities.AppointmentEntity;
import com.app.entities.UserEntity;
import com.app.exception.InvalidCredentialExc;
import com.app.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public UserRespDTO logIn(AuthDTO dto) {
		UserEntity user=userRepository.findByEmailAndPassword
				(dto.getEmail(),dto.getPassword())
				.orElseThrow(()->new InvalidCredentialExc("invalid credential!"));
		return modelMapper.map(user, UserRespDTO.class);		
	}


	@Override
	public ApiResponse signUp(RegDTO dto) {
		UserEntity user=modelMapper.map(dto, UserEntity.class);
		userRepository.save(user);
		return new ApiResponse("User registered..");
	}


	@Override
	public List<UserRespDTO> getAllUsers() {
		
		return userRepository.findAll()
				.stream()
				.map(user->modelMapper.map(user, UserRespDTO.class))
				.collect(Collectors.toList());
	}


	@Override
	public UserRespDTO getUser(Long userId) {
//		return modelMapper.map(userRepository.findById(userId), UserRespDTO.class) ;
		UserEntity user=userRepository.findById(userId)
				.orElseThrow(()->new InvalidCredentialExc("invalid user id!"));
		return modelMapper.map(user, UserRespDTO.class);
	}


	@Override
	public ApiResponse updateUserDetails(UpdateDTO dto) {
		UserEntity user=modelMapper.map(dto, UserEntity.class);
		userRepository.save(user);
		return new ApiResponse("User updated successfully");
	}
	@Override
	public List<AppointRespDTO> getAllAppointment(@Valid Long userId) {
		UserEntity user=userRepository.findById(userId)
				.orElseThrow(()->new InvalidCredentialExc("Invalid user id"));
		System.out.println(user);
		List<AppointmentEntity> app=user.getAppointment();
		return app.stream()
				.map(appointment->modelMapper.map(appointment, AppointRespDTO.class))
				.collect(Collectors.toList());
	}


}
