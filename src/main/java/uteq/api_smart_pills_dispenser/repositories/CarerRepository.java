package uteq.api_smart_pills_dispenser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uteq.api_smart_pills_dispenser.models.Carer;
import uteq.api_smart_pills_dispenser.models.Patient;

import java.util.List;

@Repository
public interface CarerRepository extends JpaRepository<Carer, Integer> {

}
