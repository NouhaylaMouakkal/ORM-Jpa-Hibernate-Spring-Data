package com.nouhayla.tp2.web;

import com.nouhayla.tp2.entities.Patient;
import com.nouhayla.tp2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patient")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
    @GetMapping ("/patient/{id}")
    public Patient patient(@PathVariable Long id){
        return patientRepository.findById(id).get();
    }
}