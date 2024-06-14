package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.AppointRespDTO;
import com.app.dto.AuthDTO;
import com.app.dto.RegDTO;
import com.app.dto.UpdateDTO;
import com.app.dto.UserRespDTO;

public interface UserService {

	UserRespDTO logIn(AuthDTO dto);

	ApiResponse signUp(RegDTO dto);

	List<UserRespDTO> getAllUsers();

	UserRespDTO getUser(Long userId);

	ApiResponse updateUserDetails(UpdateDTO dto);

	List<AppointRespDTO> getAllAppointment(@Valid Long userId);

}
