package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dto.AppointRespDTO;
import com.app.dto.AppointmentDTO;
import com.app.entities.AppointmentEntity;
import com.app.entities.DoctorEntity;
import com.app.entities.UserEntity;
import com.app.exception.InvalidCredentialExc;
import com.app.repository.AppointmentRepository;
import com.app.repository.DoctorRepository;
import com.app.repository.UserRepository;
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DoctorRepository doctorRepository;
//	private UserEntity user;
	
	@Override
	
	public List<AppointRespDTO> listAllAppointments() {

		return appointmentRepository.findAll()
				.stream()
				.map(appointment->modelMapper.map(appointment, AppointRespDTO.class))
				.collect(Collectors.toList());
	}
//	@Override
//	public List<AppointRespDTO> listUserAppointments(@Valid Long patientId) {
//		List<AppointmentEntity> app
//		return userRepository.
//				.stream()
//				.map(appointment->modelMapper.map(appointment, AppointRespDTO.class))
//				.collect(Collectors.toList());

//	}
	@Override
	public AppointRespDTO addAppointment(AppointmentDTO dto) {
		UserEntity user=userRepository.findById(dto.getPatient())
				.orElseThrow(()->new InvalidCredentialExc("Invalid patient id"));
		DoctorEntity doctor=doctorRepository.findById(dto.getDoctor())
				.orElseThrow(()->new InvalidCredentialExc("Invalid doctor id"));
		AppointmentEntity appointment=modelMapper.map(dto, AppointmentEntity.class);
		System.out.println(appointment);
		
			appointment.setPatient(user);
			appointment.setDoctor(doctor);
			user.addAppointment(appointment);
			appointmentRepository.save(appointment);
		
		
		
		
		
		
		return modelMapper.map(appointment, AppointRespDTO.class);
		
		
		
	}

	@Override
	public List<AppointRespDTO> listUserAppointments(@Valid Long doctorId) {
		List<AppointmentEntity> app=appointmentRepository.findByDrId(doctorId);
		return app.stream()
				.map(appointment->modelMapper.map(appointment, AppointRespDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String deleteOneAppointment(Long appointmentId) {
		if(appointmentRepository.existsById(appointmentId)) {
			appointmentRepository.deleteById(appointmentId);
			return "Appoinment deleted...";
		}
		return "Appointment id is not valid";
	}
	

}
