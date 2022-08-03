package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dosage")
public class Dosage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "registration_date")
    private Date registration_date;

    @Column(name = "registration_of_expiry")
    private Date registration_of_expiry;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "hour")
    private String hour;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_pill")
    Pill pill;

    @ManyToOne
    @JoinColumn(name = "id_medical_treatment")
    MedicalTreatment medicalTreatment;

}
