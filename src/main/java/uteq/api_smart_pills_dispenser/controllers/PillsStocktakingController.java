package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("api/pillsstocktakings")
@CrossOrigin("*")
public class PillsStocktakingController {

    @Autowired
    private PacienteService pacienteService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Patient>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(pacienteService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Patient> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(pacienteService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Patient> create (@RequestBody Patient entity)
    {
        try
        {
            return ResponseEntity.ok().body(pacienteService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pacienteService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Patient>update(@PathVariable int id, @RequestBody Patient entity)
    {
        try
        {
            return ResponseEntity.ok().body(pacienteService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
