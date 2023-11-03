package com.HMS.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HMS.entity.Patient_ent;
import com.HMS.exception.ResourceNotFoundException;
import com.HMS.model.PatientDTO;
import com.HMS.repository.Patient_repository;
import com.HMS.service.Patient_service;
import com.HMS.utility.Converter;

@Service
public class Patient_serviceimpl implements Patient_service {
	
	@Autowired
	private Patient_repository patientRepo;

	@Autowired
	private Converter converter;
	
	@Override
	public PatientDTO createPatient(Patient_ent patient_ent) {
		Patient_ent patient_ent2 = patientRepo.save(patient_ent);
		return converter.convertToDTO(patient_ent2);
	}

	@Override
	public List<PatientDTO> getAllPatient() {
		List<Patient_ent> patient_ent3 = patientRepo.findAll();
		List<PatientDTO> dtoList = new ArrayList<>();

		for (Patient_ent patient_ent : patient_ent3) {
			dtoList.add(converter.convertToDTO(patient_ent));
		}

		return dtoList;
	}

	@Override
	public PatientDTO getPatientById(int id) {
		Patient_ent patientEnt = patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient ", " patient_id ", id));
		return converter.convertToDTO(patientEnt);
	}

	@Override
	public PatientDTO updateById(int id, Patient_ent patient_ent) {
		Patient_ent patientEnt1 = patientRepo.findById(id).get();
		patientEnt1.setName(patient_ent.getName());
		patientEnt1.setTreatment(patient_ent.getTreatment());
		patientEnt1.setPhone(patient_ent.getPhone());

		Patient_ent stdEnt2 = patientRepo.save(patientEnt1);

		return converter.convertToDTO(stdEnt2);	}

	@Override
	public String deleteById(int id) {
		patientRepo.deleteById(id);
		return "patient deleted id:- " + id;
	}
	
	
}
