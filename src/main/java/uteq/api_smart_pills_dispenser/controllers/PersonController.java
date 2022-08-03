package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Person;
import uteq.api_smart_pills_dispenser.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("api/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonService personService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Person>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(personService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Person> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(personService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Person> create (@RequestBody Person entity)
    {
        try
        {
            return ResponseEntity.ok().body(personService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Person>update(@PathVariable int id, @RequestBody Person entity)
    {
        try
        {
            return ResponseEntity.ok().body(personService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
