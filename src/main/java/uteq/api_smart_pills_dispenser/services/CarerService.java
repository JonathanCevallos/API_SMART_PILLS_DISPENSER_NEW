package uteq.api_smart_pills_dispenser.services;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Carer;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.repositories.CarerRepository;
import uteq.api_smart_pills_dispenser.repositories.PatientRepositirory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarerService {
    @Autowired
    private CarerRepository carerRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Carer> findAll() throws Exception {
        try {
            return carerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    //Este metodo permite: Byscar un país mediante su ID.
    public Carer findById(Integer id) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Carer save(Carer entity) throws Exception {
        try {
            Carer carer=new Carer();
            carer.setName(entity.getName().trim().toUpperCase());
            carer.setEmail(entity.getEmail().trim().toUpperCase());
            carer.setRegistration_date(entity.getRegistration_date());
            carer.setPhone_number(entity.getPhone_number().trim().toUpperCase());
            carer.setState(false);
            carer.setPassword(entity.getPassword().trim());
            String randonCode = RandomString.make(8);
            carer.setVerificationCode(randonCode);
            carer = carerRepository.save(carer);
            return carer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Carer update(Integer id, Carer entity) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            Carer carer = entityOptional.get();
            carer = carerRepository.save(entity);
            return carer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (carerRepository.existsById(id)) {
                carerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
