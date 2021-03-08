package com.ga.doctorapp.dao;

import org.springframework.data.repository.CrudRepository;
import com.ga.doctorapp.model.Doctor;

public interface DoctorDao extends CrudRepository<Doctor, Integer> {
	public Doctor findById(int id);

}
