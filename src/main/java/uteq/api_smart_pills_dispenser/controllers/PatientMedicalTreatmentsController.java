package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uteq.api_smart_pills_dispenser.models.MedicalTreatment;
import uteq.api_smart_pills_dispenser.models.Patient;
import uteq.api_smart_pills_dispenser.repositories.MedicalTreatmentRepository;
import uteq.api_smart_pills_dispenser.repositories.PatientRepositirory;
import uteq.api_smart_pills_dispenser.services.CarerService;

import java.util.List;

@RestController
@RequestMapping("api/patient/medical-treatments")
@CrossOrigin("*")
public class PatientMedicalTreatmentsController {
    @Autowired
    private CarerService carerService;
    @Autowired
    private MedicalTreatmentRepository medicalTreatmentRepository;

    //LISTAR TODOS LOS PATIENTS DE UN CARER
    @RequestMapping(value = "{id}")
    public ResponseEntity<List<MedicalTreatment>> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(medicalTreatmentRepository.findByPatient_Id(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }


}
