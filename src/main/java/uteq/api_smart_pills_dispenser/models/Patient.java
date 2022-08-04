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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "registration_date")
    private LocalDateTime registration_date;

    @Column(name = "state")
    private Boolean state = true;

    @ManyToOne
    @JoinColumn(name = "id_person")
    Person person;

    @ManyToOne
    @JoinColumn(name = "id_carer")
    Carer carer;

    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }

}
