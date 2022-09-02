package uteq.api_smart_pills_dispenser.repositories;

import org.hibernate.boot.model.source.internal.hbm.NamedQueryBinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uteq.api_smart_pills_dispenser.models.Dosage;
import uteq.api_smart_pills_dispenser.models.MedicalTreatment;

import javax.validation.constraints.FutureOrPresent;
import java.util.List;

@Repository
public interface MedicalTreatmentRepository extends JpaRepository<MedicalTreatment, Integer> {
 List<MedicalTreatment>findByPatient_Id(int id);
}
