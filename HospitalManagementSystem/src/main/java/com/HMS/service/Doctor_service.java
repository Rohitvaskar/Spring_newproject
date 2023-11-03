package com.HMS.service;

import java.util.List;

import com.HMS.entity.Doctor_ent;

import com.HMS.model.DoctorDTO;


public interface Doctor_service {
	
	DoctorDTO registerDoctor(Doctor_ent doctor_ent);

	String assingPatientToDoctor(int doctor_id, int patient_id);
	List<DoctorDTO> getAllDoctor();
	DoctorDTO getDoctorById(int id);
	
	DoctorDTO updateById(int id, Doctor_ent doctor_ent);
	String deleteById(int id);


}
