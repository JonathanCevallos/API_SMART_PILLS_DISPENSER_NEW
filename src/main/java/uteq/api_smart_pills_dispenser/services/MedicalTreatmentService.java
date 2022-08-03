package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.MedicalTreatment;
import uteq.api_smart_pills_dispenser.repositories.MedicalTreatmentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MedicalTreatmentService {
    @Autowired
    private MedicalTreatmentRepository medicalTreatmentRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<MedicalTreatment> findAll() throws Exception {
        try {
            return medicalTreatmentRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public MedicalTreatment findById(Integer id) throws Exception {
        try {
            Optional<MedicalTreatment> entityOptional = medicalTreatmentRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public MedicalTreatment save(MedicalTreatment entity) throws Exception {
        try {
            entity = medicalTreatmentRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public MedicalTreatment update(Integer id, MedicalTreatment entity) throws Exception {
        try {
            Optional<MedicalTreatment> entityOptional = medicalTreatmentRepository.findById(id);
            MedicalTreatment dosage = entityOptional.get();
            dosage = medicalTreatmentRepository.save(entity);
            return dosage;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (medicalTreatmentRepository.existsById(id)) {
                medicalTreatmentRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
