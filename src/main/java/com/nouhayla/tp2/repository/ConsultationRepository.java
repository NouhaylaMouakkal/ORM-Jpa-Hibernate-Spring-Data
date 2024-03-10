package com.nouhayla.tp2.repository;
import com.nouhayla.tp2.entities.Consultation;
import com.nouhayla.tp2.entities.RDV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
}