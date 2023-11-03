package com.HMS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient_ent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	@Column(length = 35)
	private String name;
	@Column(length = 100)
	private String treatment;
	@Column(unique = true)
	private String phone;
	

	private boolean status = Boolean.TRUE;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "doctor_id")
	@JsonIgnoreProperties("patients")
	private Doctor_ent doctor;
}
