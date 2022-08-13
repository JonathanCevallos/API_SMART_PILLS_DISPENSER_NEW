package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "id_person")
    Person person;


    @PrePersist
    public void PrePersist() {
       registration_date = LocalDateTime.now();
    }
}
