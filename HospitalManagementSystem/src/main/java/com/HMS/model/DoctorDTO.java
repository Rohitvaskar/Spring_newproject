package com.HMS.model;

import java.util.List;

import com.HMS.entity.Patient_ent;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DoctorDTO {
	@NotNull
	private int doctor_id;
	@NotNull
	@Size(min = 2, max = 35, message = "your name should be minmum 2 or maximum 35 characters...")
	private String name;
	@NotNull
	@Size(min = 10, max = 100, message = "your specification should be minmum 10 or maximum 100 characters...")
	private String specification;
	@NotNull
	private String phone;

	private boolean status = Boolean.TRUE;

	List<Patient_ent> patients;


}
