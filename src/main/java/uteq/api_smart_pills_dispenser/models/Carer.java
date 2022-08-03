package uteq.api_smart_pills_dispenser.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Boolean state;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "registration_date")
    private Date registration_date;

    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;


    @PreDestroy
    public void registrationDate(){
        SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        Date registration_date_server =  new Date();
        registration_date = registration_date_server;
    }
}
