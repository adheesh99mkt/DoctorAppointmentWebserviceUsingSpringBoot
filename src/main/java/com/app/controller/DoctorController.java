package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.DoctorDTO;
import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public List<DoctorDTO> getAllDoctors(){
		return doctorService.listOfDoctors();
	}
	//@PreAuthorize("hasRole('ADMIN')") it is coming under autherisation spring security
	@PostMapping
	public ApiResponse addDoctor(@RequestBody DoctorDTO dto) {
		return doctorService.enrollDoctor(dto);
		
	}
}
