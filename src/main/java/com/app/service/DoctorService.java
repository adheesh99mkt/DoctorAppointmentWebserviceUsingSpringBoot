package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DoctorDTO;

public interface DoctorService {

	List<DoctorDTO> listOfDoctors();

	ApiResponse enrollDoctor(DoctorDTO dto);

}
