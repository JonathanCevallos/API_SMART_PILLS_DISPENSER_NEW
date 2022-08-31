package uteq.api_smart_pills_dispenser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uteq.api_smart_pills_dispenser.models.Dosage;
import uteq.api_smart_pills_dispenser.repositories.DosageRepository;

import java.util.List;

@RestController
@RequestMapping("api/medical-treatment/dosages")
@CrossOrigin("*")
public class MedicalTreatmentDosagesController {
    @Autowired
    DosageRepository dosageRepository;
    @RequestMapping(value = "{id}")
    public ResponseEntity<List<Dosage>> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(dosageRepository.findByMedicalTreatment_Id(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
}
