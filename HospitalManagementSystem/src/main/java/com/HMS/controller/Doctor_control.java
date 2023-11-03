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

import com.HMS.entity.Doctor_ent;
import com.HMS.model.DoctorDTO;
import com.HMS.service.Doctor_service;
import com.HMS.utility.Converter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Doctor_control {
	@Autowired
	private Doctor_service doctor_service;
	@Autowired
	private Converter converter;

	@PostMapping("/createdoctor")
	ResponseEntity<DoctorDTO> createPatient(@Valid @RequestBody DoctorDTO doctorDTO) {

		final Doctor_ent doctor_ent = converter.convertToDoctorEntity(doctorDTO);
		return new ResponseEntity<DoctorDTO>(doctor_service.registerDoctor(doctor_ent), HttpStatus.CREATED);
	}

	@PostMapping("/assing/{doctor_id}/{patient_id}")
	public String assingPatientToDoctor(@PathVariable("doctor_id") int doctor_id,
			@PathVariable("patient_id") int patient_id) {
		return doctor_service.assingPatientToDoctor(doctor_id, patient_id);

	}

	@GetMapping("/getalldoctors")
	List<DoctorDTO> getAllDoctor() {
		return doctor_service.getAllDoctor();

	}

	@GetMapping("/getdoctorbyid/{doctor_id}")
	DoctorDTO getDoctorById(@PathVariable("doctor_id") int id) {
		return doctor_service.getDoctorById(id);
	}

	@PutMapping("/updatedoctorbyid/{doctor_id}")
	DoctorDTO updateDoctor(@Valid @PathVariable("doctor_id") int id, @RequestBody DoctorDTO doctorDto) {
		final Doctor_ent doctor_ent4 = converter.convertToDoctorEntity(doctorDto);
		return doctor_service.updateById(id, doctor_ent4);
	}

	@DeleteMapping("/deletedoctorbyid/{doctor_id}")
	String deletebyid(@PathVariable("doctor_id") int id) {
		return doctor_service.deleteById(id);

	}
}
