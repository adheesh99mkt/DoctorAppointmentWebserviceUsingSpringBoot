package com.app.dto;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
public class FeedbackDTO extends BaseDTO{
	@Length(min=1,max=100,message = "Invalid feedback")
	private String comment;
	@Min(1)
	@Max(5)
	private int rating;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Long commenterId;
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	private Long doctorId;
	
}
