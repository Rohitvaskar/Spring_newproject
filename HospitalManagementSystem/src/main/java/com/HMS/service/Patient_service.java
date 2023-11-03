package com.HMS.service;

import java.util.List;

import com.HMS.entity.Patient_ent;
import com.HMS.model.PatientDTO;

public interface Patient_service {
	
//	for create new student
//	Student_ent createStudent(Student_ent student_ent);
	PatientDTO createPatient(Patient_ent patient_ent);

//	fetch all student data
//	List<Student_ent> getAllStudent();
	List<PatientDTO> getAllPatient();

//	fetch by id
//	Student_ent getStudentById(int id);
	PatientDTO getPatientById(int id);

//	update by id
//	Student_ent updateById(int id, Student_ent student_ent);
	PatientDTO updateById(int id, Patient_ent patient_ent);

//	delete by id
//	String deleteById(int id);
	String deleteById(int id);

}
