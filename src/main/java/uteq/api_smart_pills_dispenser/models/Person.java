package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "name")
    private String name;

    @Column(name = "birt_date")
    private int birt_date;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;


    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;


}
