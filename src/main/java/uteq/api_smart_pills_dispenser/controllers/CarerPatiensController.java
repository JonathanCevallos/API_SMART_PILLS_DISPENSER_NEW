package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uteq.api_smart_pills_dispenser.models.Carer;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.repositories.PatientRepositirory;
import uteq.api_smart_pills_dispenser.services.CarerService;

import java.util.List;

@RestController
@RequestMapping("api/carer/patients")
@CrossOrigin("*")
public class CarerPatiensController {
    @Autowired
    private CarerService carerService;
    @Autowired
    private PatientRepositirory patientRepositirory;

    //LISTAR TODOS LOS PATIENTS DE UN CARER
    @RequestMapping(value = "{id}")
    public ResponseEntity<List<Patient>> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(patientRepositirory.findByCarer_Id(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }


}
