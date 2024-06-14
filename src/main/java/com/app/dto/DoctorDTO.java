package com.app.dto;



import com.app.entities.DoctorCategory;

import lombok.*;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO extends BaseDTO{
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone_no;
	private DoctorCategory category;
}

