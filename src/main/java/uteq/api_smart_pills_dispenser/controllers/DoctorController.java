package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Doctor;
import uteq.api_smart_pills_dispenser.services.DoctorService;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Doctor>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Doctor> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Doctor> create (@RequestBody Doctor entity)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(doctorService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Doctor>update(@PathVariable int id, @RequestBody Doctor entity)
    {
        try
        {
            return ResponseEntity.ok().body(doctorService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
