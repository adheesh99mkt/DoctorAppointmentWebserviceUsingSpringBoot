package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class DoctorEntity extends BaseEntity {
	@Column(length=20,name="first_name")
	private String first_name;
	@Column(length=20,name="last_name")
	private String last_name;
	@Column(length=20,name="email" ,unique=true)
	private String email;
	@Column(name = "phone_no", length = 14, unique = true)
	private String phone_no;
	@Enumerated(EnumType.STRING)
	@Column(name="category")
	private DoctorCategory category;
	
	
//	@OneToOne(mappedBy = "doctor",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private AppointmentEntity appointment;
	
	
}
