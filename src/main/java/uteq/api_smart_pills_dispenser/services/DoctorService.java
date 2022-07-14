package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Doctor;
import uteq.api_smart_pills_dispenser.repositories.DoctorRepository;
import uteq.api_smart_pills_dispenser.repositories.PacienteRepsotirory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Doctor> findAll() throws Exception {
        try {
            return doctorRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Doctor findById(Integer id) throws Exception {
        try {
            Optional<Doctor> entityOptional = doctorRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Doctor save(Doctor entity) throws Exception {
        try {
            entity = doctorRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Doctor update(Integer id, Doctor entity) throws Exception {
        try {
            Optional<Doctor> entityOptional = doctorRepository.findById(id);
            Doctor doctor = entityOptional.get();
            doctor = doctorRepository.save(entity);
            return doctor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (doctorRepository.existsById(id)) {
                doctorRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
