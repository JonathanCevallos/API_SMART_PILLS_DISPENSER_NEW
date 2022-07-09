package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.repositories.PacienteRepsotirory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PacienteService {
    @Autowired
    private PacienteRepsotirory pacienteRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Patient> findAll() throws Exception {
        try {
            return pacienteRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Patient findById(Integer id) throws Exception {
        try {
            Optional<Patient> entityOptional = pacienteRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Patient save(Patient entity) throws Exception {
        try {
            entity = pacienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Patient update(Integer id, Patient entity) throws Exception {
        try {
            Optional<Patient> entityOptional = pacienteRepository.findById(id);
            Patient tema = entityOptional.get();
            tema = pacienteRepository.save(entity);
            return tema;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (pacienteRepository.existsById(id)) {
                pacienteRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
