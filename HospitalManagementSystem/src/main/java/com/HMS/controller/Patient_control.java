package com.HMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS.entity.Patient_ent;
import com.HMS.model.PatientDTO;
import com.HMS.service.Patient_service;
import com.HMS.utility.Converter;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class Patient_control {
	
	@Autowired
	private Patient_service patientSerive;

	@Autowired
	private Converter converter;

//	---------------------------------------------------------------------------------------------------------------------------------



	@PostMapping("/createpatient")
	ResponseEntity<PatientDTO> createStudent(@Valid @RequestBody PatientDTO patientDTO) {

		final Patient_ent patient_ent = converter.convertToEntity(patientDTO);
		return new ResponseEntity<PatientDTO>(patientSerive.createPatient(patient_ent), HttpStatus.CREATED);
	}

//	---------------------------------------------------------------------------------------------------------------------------------



	@GetMapping("/getallpatientss")
	List<PatientDTO> getAllPatient() {
		return patientSerive.getAllPatient();

	}

//	---------------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/getbyid/{patient_id}")
	PatientDTO getPatientById(@PathVariable("patient_id") int id) {
		return patientSerive.getPatientById(id);
	}

//	---------------------------------------------------------------------------------------------------------------------------------



	@PutMapping("/updatebyid/{patient_id}")
	PatientDTO updatePatient(@Valid @PathVariable("patient_id") int id, @RequestBody PatientDTO patientDto) {
		final Patient_ent patient_ent4 = converter.convertToEntity(patientDto);
		return patientSerive.updateById(id, patient_ent4);
	}

//	---------------------------------------------------------------------------------------------------------------------------------

	@DeleteMapping("/deletebyid/{patient_id}")
	String deletebyid(@PathVariable("patient_id") int id) {
		return patientSerive.deleteById(id);

	}


}
