package com.nouhayla.tp2.repository;
import com.nouhayla.tp2.entities.Medecin;
import com.nouhayla.tp2.entities.RDV;
import com.nouhayla.tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RDVRepository extends JpaRepository<RDV, Long>{
}
