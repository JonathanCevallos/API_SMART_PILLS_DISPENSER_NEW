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
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "specialism", length = 25)
    private String specialism;

    @Column(name = "state")
    private boolean state = true;

    @Column(name = "phone_number", length = 15)
    private String phone_number;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "direction", length = 150)
    private String direction;


    @Column(name = "registration_date")
    private LocalDateTime registration_date;


    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }
}
