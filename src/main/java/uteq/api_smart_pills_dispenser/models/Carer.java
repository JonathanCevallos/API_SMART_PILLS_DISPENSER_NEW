package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    private Boolean state;
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

    @Column(name="verification_code",length = 8, updatable = false)
    private String verificationCode;


    //@OneToMany(mappedBy = "carer", cascade = CascadeType.ALL)
    //Set<Patient> patients = new HashSet<>();


    @PrePersist
    public void PrePersist() {
        registration_date = LocalDateTime.now();
    }
}
