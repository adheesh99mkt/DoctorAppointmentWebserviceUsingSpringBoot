package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.*;
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class UserEntity extends BaseEntity {
	@Column(length=20,name="first_name")
	private String first_name;
	@Column(length=20,name="last_name")
	private String last_name;
	@Column(length=20,name="email" ,unique=true)
	private String email;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="dob")
	private LocalDate dob;
	@Column(length=10,name="phone")
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(length=20,name="role")
	private UserRole role;
	@Lob
	@Column(name="image")
	private byte[] image;
//	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)

	private List<AppointmentEntity> appointment=new ArrayList<AppointmentEntity>();
	
	public void addAppointment(AppointmentEntity app) {
		appointment.add(app);
		app.setPatient(this);
	}
	public void removeAppointment(AppointmentEntity app) {
		appointment.remove(app);
		app.setPatient(null);
	}
}
