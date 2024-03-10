package com.nouhayla.tp2.service;
import com.nouhayla.tp2.entities.RDV;
import com.nouhayla.tp2.entities.Medecin;
import com.nouhayla.tp2.entities.Patient;
import com.nouhayla.tp2.entities.Consultation;
public interface IHospital {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RDV saveRendezVous(RDV r);
    Consultation saveConsultation(Consultation c);
}