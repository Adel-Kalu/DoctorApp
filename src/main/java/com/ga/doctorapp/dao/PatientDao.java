package com.ga.doctorapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.doctorapp.model.Patient;

public interface PatientDao extends CrudRepository<Patient, Integer> {
	public Patient findById(int id);
}