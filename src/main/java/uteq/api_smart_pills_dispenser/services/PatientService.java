package uteq.api_smart_pills_dispenser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.repositories.PatientRepositirory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PatientService {
    @Autowired
    private PatientRepositirory patientRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Patient> findAll() throws Exception {
        try {
            return patientRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite listar todos los registro de pacientes que tiene el cuidador.
    public List<Patient> findAllPatiens(int id) throws Exception {
        try {
            return patientRepository.findByCarer_Id(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    //Este metodo permite: Actualizar un país mediante su ID.
    public Patient findById(Integer id) throws Exception {
        try {
            Optional<Patient> entityOptional = patientRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Patient save(Patient entity) throws Exception {
        try {
            entity = patientRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Patient update(Integer id, Patient entity) throws Exception {
        try {
            Optional<Patient> entityOptional = patientRepository.findById(id);
            Patient patient = entityOptional.get();
            patient = patientRepository.save(entity);
            return patient;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (patientRepository.existsById(id)) {
                patientRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
