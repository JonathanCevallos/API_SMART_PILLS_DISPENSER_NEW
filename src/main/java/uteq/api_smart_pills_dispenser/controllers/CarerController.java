package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Carer;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.services.CarerService;
import uteq.api_smart_pills_dispenser.services.PatientService;

import java.util.List;

@RestController
@RequestMapping("api/carer")
@CrossOrigin("*")
public class CarerController {

    @Autowired
    private CarerService carerService;

    @Autowired
    PatientService patientService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Carer>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(carerService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //LISTAR TODO LOS PACIENTES QUE TIENE
    @GetMapping("/patiens")
    public ResponseEntity<List<Patient>> getAll(int id)
    {
        try
        {
            return ResponseEntity.ok().body(patientService.findAllPatiens(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Carer> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(carerService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Carer> create (@RequestBody Carer entity)
    {
        try
        {
            return ResponseEntity.ok().body(carerService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(carerService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Carer>update(@PathVariable int id, @RequestBody Carer entity)
    {
        try
        {
            return ResponseEntity.ok().body(carerService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
