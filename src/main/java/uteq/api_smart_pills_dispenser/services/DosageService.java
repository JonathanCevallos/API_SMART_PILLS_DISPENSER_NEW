package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Dosage;
import uteq.api_smart_pills_dispenser.repositories.DosageRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DosageService {
    @Autowired
    private DosageRepository dosageRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Dosage> findAll() throws Exception {
        try {
            return dosageRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Dosage findById(Integer id) throws Exception {
        try {
            Optional<Dosage> entityOptional = dosageRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Dosage save(Dosage entity) throws Exception {
        try {
            entity = dosageRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Dosage update(Integer id, Dosage entity) throws Exception {
        try {
            Optional<Dosage> entityOptional = dosageRepository.findById(id);
            Dosage dosage = entityOptional.get();
            dosage = dosageRepository.save(entity);
            return dosage;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (dosageRepository.existsById(id)) {
                dosageRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
