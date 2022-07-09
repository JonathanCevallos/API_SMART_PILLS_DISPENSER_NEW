package uteq.api_smart_pills_dispenser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.api_smart_pills_dispenser.models.Patient;

@Repository
public interface PacienteRepsotirory extends JpaRepository<Patient, Integer> {
}
