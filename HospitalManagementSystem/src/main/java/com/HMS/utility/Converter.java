package com.HMS.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.HMS.entity.Doctor_ent;
import com.HMS.entity.Patient_ent;
import com.HMS.model.DoctorDTO;
import com.HMS.model.PatientDTO;


@Component
public class Converter {
	
//	convert from DTO to Entity
	public Patient_ent convertToEntity(PatientDTO patientDto) {

		Patient_ent patientEnt = new Patient_ent();
		if (patientDto != null) {
			BeanUtils.copyProperties(patientDto, patientEnt);
		}
		return patientEnt;
	}

//	convert from DTO to Entity
	public PatientDTO convertToDTO(Patient_ent patient_ent) {

		PatientDTO patientDto = new PatientDTO();
		if (patient_ent != null) {
			BeanUtils.copyProperties(patient_ent, patientDto);
		}
		return patientDto;
	}

	// ---------------------------------------------------------------------------------------------------------

//	convert from DTO to Entity
	public Doctor_ent convertToDoctorEntity(DoctorDTO doctorDTO) {

		Doctor_ent doctorEnt = new Doctor_ent();
		if (doctorDTO != null) {
			BeanUtils.copyProperties(doctorDTO, doctorEnt);
		}
		return doctorEnt;
	}

//	convert from DTO to Entity
	public DoctorDTO convertToDoctorDTO(Doctor_ent doctor_ent) {

		DoctorDTO doctorDTO = new DoctorDTO();
		if (doctor_ent != null) {
			BeanUtils.copyProperties(doctor_ent, doctorDTO);

		}
		return doctorDTO;
	}

}
