package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime registration_date;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "start_date")
    private Date starDate;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "hour")
    private String hour;

    @Column(name = "state")
    private Boolean state = true;

    @ManyToOne
    @JoinColumn(name = "id_pill")
    Pill pill;

    @ManyToOne
    @JoinColumn(name = "id_medical_treatment")
    MedicalTreatment medicalTreatment;

    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }

}

