package com.app.entities;


import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="feedback",
uniqueConstraints = 
@UniqueConstraint(columnNames = {"patient_id","doctor_id"}))
public class FeedBackEntity extends BaseEntity{
	@Column(length=40,name="comment")
	private String comment;
	@Column(name="rating")
	private int rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patient_id",nullable=false)
	private UserEntity patient_id;
	
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable=false)
	private DoctorEntity dostor_id;
}
