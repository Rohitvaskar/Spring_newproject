package com.HMS.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor_ent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	@Column(length = 35)
	private String name;
	@Column(length = 100)
	private String specialization;
	@Column(unique = true)
	private String phone;

	
	private boolean status = Boolean.TRUE;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("doctor")

	List<Patient_ent> patients;

}
