package com.app.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.AppointmentEntity;


public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {


	@Query("select a from AppointmentEntity a where a.doctor.id=:id and a.date_slot > current_date")
	List<AppointmentEntity> findByDrId(Long id);
}

