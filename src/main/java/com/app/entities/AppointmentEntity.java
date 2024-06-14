package com.app.entities;
import java.time.LocalDate;


import javax.persistence.*;



import lombok.*;

@Getter
@Setter
@ToString(exclude = {"patient","doctor"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointments",
uniqueConstraints = 
@UniqueConstraint(columnNames = {"patient_id","doctor_id","date_slot"}))
public class AppointmentEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name="patient_id",nullable=false)
	private UserEntity patient;
	
	@OneToOne
	@JoinColumn(name="doctor_id",nullable=false)
	private DoctorEntity doctor;
	
	@Column(name="date_slot")
	private LocalDate date_slot;
//	@Column(name="time_slot")
//	private LocalTime time_slot;
}
