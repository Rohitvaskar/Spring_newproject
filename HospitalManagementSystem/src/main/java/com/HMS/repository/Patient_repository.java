package com.HMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS.entity.Patient_ent;

public interface Patient_repository extends JpaRepository<Patient_ent, Integer> {

}

