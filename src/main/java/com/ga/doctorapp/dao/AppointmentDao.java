package com.ga.doctorapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.doctorapp.model.Appointment;

public interface AppointmentDao extends CrudRepository<Appointment, Integer> {
	public Appointment findById(int id);
}