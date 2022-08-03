package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Pill;
import uteq.api_smart_pills_dispenser.repositories.PillRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PillService {
    @Autowired
    private PillRepository pillRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Pill> findAll() throws Exception {
        try {
            return pillRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Pill findById(Integer id) throws Exception {
        try {
            Optional<Pill> entityOptional = pillRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Pill save(Pill entity) throws Exception {
        try {
            entity = pillRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Pill update(Integer id, Pill entity) throws Exception {
        try {
            Optional<Pill> entityOptional = pillRepository.findById(id);
            Pill pill = entityOptional.get();
            pill = pillRepository.save(entity);
            return pill;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (pillRepository.existsById(id)) {
                pillRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
