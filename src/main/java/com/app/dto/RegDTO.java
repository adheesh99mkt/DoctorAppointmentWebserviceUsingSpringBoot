package com.app.dto;

import java.time.LocalDate;

import com.app.entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegDTO{
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private LocalDate dob;
	private String phone;
	private UserRole role;
}
