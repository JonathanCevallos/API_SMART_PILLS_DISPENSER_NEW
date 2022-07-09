package uteq.api_smart_pills_dispenser.models;

import javax.persistence.*;

@Entity
    @Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="birt_date")
    private int birt_date;

    @Column(name="gender")
    private String gender;





 /*   @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/


}
