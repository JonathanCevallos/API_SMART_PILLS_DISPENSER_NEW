package uteq.api_smart_pills_dispenser.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
@Table(name = "carer")
public class Carer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private int id;

    @Column(name = "state")
    private Boolean state = true;
    @Column(name = "registration_date")
    private LocalDateTime registration_date;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "phone_number", length = 15)
    private String phone_number;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Patient.class)
    @JoinColumn(name = "id_", referencedColumnName = "id_")
    private Set<Patient> patiens;
    //---holaaa

    @PrePersist
    public void PrePersist() {
       registration_date = LocalDateTime.now();
    }
}
