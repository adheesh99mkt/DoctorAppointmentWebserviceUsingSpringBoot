package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.dto.DoctorDTO;
import com.app.entities.DoctorEntity;
import com.app.repository.DoctorRepository;
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<DoctorDTO> listOfDoctors() {
		return doctorRepository.findAll()
				.stream()
				.map(doctors->modelMapper.map(doctors, DoctorDTO.class))
				.collect(Collectors.toList());
	}
	@Override
	public ApiResponse enrollDoctor(DoctorDTO dto) {
		DoctorEntity doctor=modelMapper.map(dto, DoctorEntity.class);
		doctorRepository.save(doctor);
		return new ApiResponse("Doctor added...");
	}
	

}
