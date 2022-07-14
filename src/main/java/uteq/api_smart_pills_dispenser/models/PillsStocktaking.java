package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pillsStocktaking")
public class PillsStocktaking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "registration_date")
    private Date registration_date;

    @Column(name = "registration_of_expiry")
    private Date registration_of_expiry;

    @Column(name = "stock")
    private int stock;



 /*   @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;*/


}
