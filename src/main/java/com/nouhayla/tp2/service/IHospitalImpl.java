package com.nouhayla.tp2.service;
import jakarta.transaction.Transactional;
import com.nouhayla.tp2.entities.Consultation;
import com.nouhayla.tp2.entities.Medecin;
import com.nouhayla.tp2.entities.Patient;
import com.nouhayla.tp2.entities.RDV;
import com.nouhayla.tp2.repository.ConsultationRepository;
import com.nouhayla.tp2.repository.MedecinRepository;
import com.nouhayla.tp2.repository.PatientRepository;
import com.nouhayla.tp2.repository.RDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class IHospitalImpl implements IHospital {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RDVRepository rdvRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RDVRepository rdvRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rdvRepository = rdvRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RDV saveRendezVous(RDV r) {
        return rdvRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }
}