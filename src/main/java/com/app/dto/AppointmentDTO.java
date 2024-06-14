package com.app.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class AppointmentDTO extends BaseDTO{
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long patient;
//	private String patient_name;
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long doctor;
//	private String doctor_name;
	@JsonProperty(access = Access.WRITE_ONLY)
	private LocalDate date_slot;
	//private LocalTime time_slot;
}
