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
public class AppointRespDTO extends BaseDTO {
		@JsonProperty(access = Access.READ_ONLY)
		private UserId patient;
		@JsonProperty(access = Access.READ_ONLY)
		private DoctorId doctor;
		@JsonProperty(access = Access.READ_ONLY)
		private LocalDate date_slot;
		//private LocalTime time_slot;
}

