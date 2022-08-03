package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Dosage;
import uteq.api_smart_pills_dispenser.services.DosageService;

import java.util.List;

@RestController
@RequestMapping("api/dosage")
@CrossOrigin("*")
public class DosageController {

    @Autowired
    private DosageService dosageService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Dosage>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(dosageService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Dosage> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(dosageService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Dosage> create (@RequestBody Dosage entity)
    {
        try
        {
            return ResponseEntity.ok().body(dosageService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dosageService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Dosage>update(@PathVariable int id, @RequestBody Dosage entity)
    {
        try
        {
            return ResponseEntity.ok().body(dosageService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
