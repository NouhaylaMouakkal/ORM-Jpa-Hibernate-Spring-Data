package com.nouhayla.tp2;

import com.nouhayla.tp2.entities.*;
import com.nouhayla.tp2.repository.ConsultationRepository;
import com.nouhayla.tp2.repository.MedecinRepository;
import com.nouhayla.tp2.repository.PatientRepository;
import com.nouhayla.tp2.repository.RDVRepository;
import com.nouhayla.tp2.service.IHospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2Application {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RDVRepository rdvRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospital iHospital, PatientRepository patientRepository, MedecinRepository medecinRepository,
                            RDVRepository rdvRepository, ConsultationRepository consultationRepository) { 
        return args -> {
            // Patient
            patientRepository.save(new Patient(null, "Nouhayla", new Date(), true, 360, null));
            patientRepository.save(new Patient(null, "Imad", new Date(), true, 200, null));
            patientRepository.save(new Patient(null, "Wassima", new Date(), false, 220, null));

            // Medecin
            Stream.of("Hammi", "Moumkin", "Belfkih").forEach(m -> {
                Medecin medecin = new Medecin();
                medecin.setName(m);
                medecin.setEmail(m + "@fmpt.ma");
                medecin.setSpecialite(Math.random() > 0.5 ? "Pneumologue" : "Neurologue");
                iHospital.saveMedecin(medecin);
            });

            // RendezVous
            RDV rdv = new RDV();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRDV.CONFIRMED);
            rdv.setPatient(patientRepository.findById(1L).orElse(null)); 
            rdv.setMedecin(medecinRepository.findById(1L).orElse(null)); 
            rdvRepository.save(rdv); // Corrected

            RDV rdv1 = rdvRepository.findById(1L).orElse(null); 

            // Consultation
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRdv(rdv1);
            consultation.setRapport("Rapport de consultation");
            iHospital.saveConsultation(consultation);
        };
    }
}
