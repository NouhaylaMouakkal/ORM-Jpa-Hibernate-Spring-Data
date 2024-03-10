package com.nouhayla.tp2.repository;
import com.nouhayla.tp2.entities.Medecin;
import com.nouhayla.tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    List<Medecin> findByNameContains(String name);
    @Query("select p from Medecin p where p.name like :x")
    List<Medecin> search(@Param("x") String mc);
}