package uteq.api_smart_pills_dispenser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.api_smart_pills_dispenser.models.Dosage;

import java.util.List;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Integer> {
    List<Dosage> findByMedicalTreatment_Id(int id);
}
