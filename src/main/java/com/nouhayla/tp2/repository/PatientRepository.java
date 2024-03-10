package com.nouhayla.tp2.repository;
import com.nouhayla.tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContains(String name);
    Patient findByName(String name);
    @Query("select p from Patient p where p.name like :x")
    List<Patient> search(@Param("x") String mc);
}


