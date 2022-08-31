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
@Table(name = "medical_treatment")
public class MedicalTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Description", length = 255)
    private String description;


    @Column(name = "registration_date")
    private LocalDateTime registration_date;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "start_date")
    private Date startDate;


    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "state")
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    Patient patient;

    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }

}
