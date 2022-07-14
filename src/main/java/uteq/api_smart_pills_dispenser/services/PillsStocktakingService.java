package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.PillsStocktaking;
import uteq.api_smart_pills_dispenser.repositories.PillsStocktakingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PillsStocktakingService {
    @Autowired
    private PillsStocktakingRepository pillsStocktakingRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<PillsStocktaking> findAll() throws Exception {
        try {
            return pillsStocktakingRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public PillsStocktaking findById(Integer id) throws Exception {
        try {
            Optional<PillsStocktaking> entityOptional = pillsStocktakingRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public PillsStocktaking save(PillsStocktaking entity) throws Exception {
        try {
            entity = pillsStocktakingRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public PillsStocktaking update(Integer id, PillsStocktaking entity) throws Exception {
        try {
            Optional<PillsStocktaking> entityOptional = pillsStocktakingRepository.findById(id);
            PillsStocktaking pillsStocktaking = entityOptional.get();
            pillsStocktaking = pillsStocktakingRepository.save(entity);
            return pillsStocktaking;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (pillsStocktakingRepository.existsById(id)) {
                pillsStocktakingRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
