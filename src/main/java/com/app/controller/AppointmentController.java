package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AppointRespDTO;
import com.app.dto.AppointmentDTO;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping
	public List<AppointRespDTO> getAppointmentList(){
		return appointmentService.listAllAppointments();
	}
	@GetMapping("/{doctorId}")
	public List<AppointRespDTO> getAppointmentList(@PathVariable @Valid Long doctorId){
		return appointmentService.listUserAppointments(doctorId);
	}
	@PostMapping
	public ResponseEntity<?> scheduleAppointment(@RequestBody AppointmentDTO dto){
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(appointmentService.addAppointment(dto));
	}
	@DeleteMapping("/{appointmentId}")
	public ApiResponse deleteAppointment(@PathVariable @Valid Long appointmentId) {
		return new ApiResponse(appointmentService.deleteOneAppointment(appointmentId));
	}
	
	
}
