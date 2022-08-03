package uteq.api_smart_pills_dispenser.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Person;
import uteq.api_smart_pills_dispenser.repositories.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Person> findAll() throws Exception {
        try {
            return personRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un país mediante su ID.
    public Person findById(Integer id) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Person save(Person entity) throws Exception {
        try {
            entity = personRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Person update(Integer id, Person entity) throws Exception {
        try {
            Optional<Person> entityOptional = personRepository.findById(id);
            Person person = entityOptional.get();
            person = personRepository.save(entity);
            return person;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (personRepository.existsById(id)) {
                personRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
