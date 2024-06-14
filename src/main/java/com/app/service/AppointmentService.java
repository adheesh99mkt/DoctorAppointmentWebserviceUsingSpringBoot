package com.app.service;

import java.util.List;

import javax.validation.Valid;


import com.app.dto.AppointRespDTO;
import com.app.dto.AppointmentDTO;


public interface AppointmentService {

	String	deleteOneAppointment(Long appointmentId);

	List<AppointRespDTO> listAllAppointments();

	//List<AppointRespDTO> listUserAppointments(@Valid Long patientId);

	AppointRespDTO addAppointment(AppointmentDTO dto);

	List<AppointRespDTO> listUserAppointments(@Valid Long doctorId);
	

}
