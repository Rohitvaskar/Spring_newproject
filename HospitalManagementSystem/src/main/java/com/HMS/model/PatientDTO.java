package com.HMS.model;

import com.HMS.entity.Doctor_ent;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PatientDTO {
		
		@NotNull
		private int patient_id;
		@NotNull
		@Size(min = 2, max = 35, message = "your name should be minmum 2 or maximum 35 characters...")
		private String name;
		@NotNull
		@Size(min = 10, max = 100, message = "your treatmenrt name should be minmum 10 or maximum 100 characters...")
		private String treatment;
		@NotNull
		private String phone;

		private Doctor_ent doctorEnt;

}

