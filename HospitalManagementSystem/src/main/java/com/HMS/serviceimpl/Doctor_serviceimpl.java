package com.HMS.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS.entity.Doctor_ent;
import com.HMS.entity.Patient_ent;
import com.HMS.exception.ResourceNotFoundException;
import com.HMS.model.DoctorDTO;

import com.HMS.repository.Doctor_repository;
import com.HMS.repository.Patient_repository;
import com.HMS.service.Doctor_service;
import com.HMS.utility.Converter;

@Service
public class Doctor_serviceimpl implements Doctor_service {

	@Autowired
	private Doctor_repository doctor_repo;

	@Autowired
	private Patient_repository patientRepo;

	@Autowired
	private Doctor_repository doctorRepo;

	@Autowired
	private Converter converter;

	

	@Override
	public DoctorDTO registerDoctor(Doctor_ent doctor_ent) {
		return converter.convertToDoctorDTO(doctor_repo.save(doctor_ent));
	}

	@Override
	public String assingPatientToDoctor(int doctor_id, int patient_id) {
		Patient_ent patientEnts = patientRepo.findById(patient_id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ", " patient_id ", patient_id));

		Doctor_ent doctorEnts = doctorRepo.findById(doctor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ", " patient_id ", doctor_id));

		List<Patient_ent> patients = new ArrayList<>();
		patients.add(patientEnts);
		doctorEnts.setPatients(patients);
		patientEnts.setDoctor(doctorEnts);
	//	doctorEnts.setPatients(patients);
	//	patientEnts.setDoctor(doctorEnts);

		doctorRepo.save(doctorEnts);

		return "Patient assing to a Doctor successfully.....";
	}

	@Override
	public List<DoctorDTO> getAllDoctor() {
		List<Doctor_ent> doctor_ent3 = doctorRepo.findAll();
		List<DoctorDTO> docList = new ArrayList<>();
		
		for (Doctor_ent doctor_ent : doctor_ent3) {
			docList.add(converter.convertToDoctorDTO(doctor_ent));
		}
		return docList;
	}

	@Override
	public DoctorDTO getDoctorById(int id) {
		Doctor_ent doctorEnt = doctorRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor ", " doctor_id ", id));
		return converter.convertToDoctorDTO(doctorEnt);
	}

	@Override
	public DoctorDTO updateById(int id, Doctor_ent doctor_ent) {
		Doctor_ent doctorEnt1 = doctorRepo.findById(id).get();
		doctorEnt1.setName(doctor_ent.getName());
		doctorEnt1.setSpecialization(doctor_ent.getSpecialization());
		doctorEnt1.setPhone(doctor_ent.getPhone());

		Doctor_ent doctorEnt2 = doctorRepo.save(doctorEnt1);

		return converter.convertToDoctorDTO(doctorEnt2);
	}

	@Override
	public String deleteById(int id) {
		doctorRepo.deleteById(id);
		return "doctor deleted id:- " + id;
	}

}
