package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 70)
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birt_date")
    private Date birt_date;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "email", length = 50)
    private String email;


    @Column(name = "phone_number", length = 20)
    private String phone_number;

    @Column(name = "state")
    private Boolean state = true;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;

}
