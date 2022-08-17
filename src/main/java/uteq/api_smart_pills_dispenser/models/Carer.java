package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
@Table(name = "carer")
public class Carer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

//    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Patient.class)
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private List<Patient> patiens;
//    //---holaaa
    @OneToMany(mappedBy = "carer" , cascade = CascadeType.ALL)
    Set<Patient> patients;


    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }
}
