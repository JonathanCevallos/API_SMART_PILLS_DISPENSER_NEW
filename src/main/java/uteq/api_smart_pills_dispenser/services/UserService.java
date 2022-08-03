package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.User;
import uteq.api_smart_pills_dispenser.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<User> findAll() throws Exception {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public User findById(Integer id) throws Exception {
        try {
            Optional<User> entityOptional = userRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public User save(User entity) throws Exception {
        try {
            entity = userRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public User update(Integer id, User entity) throws Exception {
        try {
            Optional<User> entityOptional = userRepository.findById(id);
            User user = entityOptional.get();
            user = userRepository.save(entity);
            return user;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
