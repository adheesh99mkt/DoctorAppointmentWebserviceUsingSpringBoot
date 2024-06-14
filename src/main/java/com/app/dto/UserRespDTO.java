package com.app.dto;

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
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDTO extends BaseDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private String first_name;
	@JsonProperty(access = Access.READ_ONLY)
	private String last_name;
	@JsonProperty(access = Access.READ_ONLY)
	private String phone;
	@JsonProperty(access = Access.READ_ONLY)
	private String email;
	
}
