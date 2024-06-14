package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDTO {
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private LocalDate dob;
	private String phone;
	private String role;
}
