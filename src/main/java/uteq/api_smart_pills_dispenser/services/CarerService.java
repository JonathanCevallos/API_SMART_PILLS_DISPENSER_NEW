package uteq.api_smart_pills_dispenser.services;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uteq.api_smart_pills_dispenser.models.Carer;
import uteq.api_smart_pills_dispenser.repositories.CarerRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.MidiMessage;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarerService {
    @Autowired
    private CarerRepository carerRepository;
    @Autowired
    private JavaMailSender mailSender;


    private BCryptPasswordEncoder passwordEncoder;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Carer> findAll() throws Exception {
        try {
            return carerRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }


    //Este metodo permite: Byscar un país mediante su ID.
    public Carer findById(Integer id) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Carer save(Carer entity) throws Exception {
        try {
            //se optinene la contraseña del usuario en texto plano
            String pass = entity.getPassword();
            //se encripta la contraseña del usuario
            String passEncrip = passwordEncoder.encode(pass);
            //numero random para la verificacion por correo electronico
            String randonCode = RandomString.make(8);

            //entity.setVerificationCode(randonCode);
            //entity.setState(false);
            //entity = carerRepository.save(entity);
            Carer carer = new Carer();
            carer.setName(entity.getName().trim().toUpperCase());
            carer.setEmail(entity.getEmail().trim().toUpperCase());
            carer.setRegistration_date(entity.getRegistration_date());
            carer.setPhone_number(entity.getPhone_number().trim().toUpperCase());
            carer.setState(false);
            carer.setPassword(passEncrip);
            carer.setVerificationCode(randonCode.toUpperCase());
            carer = carerRepository.save(carer);
            sendVerificationEmail(carer);
            return carer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void sendVerificationEmail(Carer carer) throws MessagingException, UnsupportedEncodingException {
        String subject = "Please verify your registration";
        String senderName= "Support Team (SMART PILLS DISPENSER)";
        String mailContent="<p>Dear"+carer.getName()+",</p>";
        mailContent += "<p>Please enter this code in the application to verify your account:</p>";
        String code = carer.getVerificationCode();
        mailContent +=" " + code + " ";
        mailContent +="<p>Tank you<br>The Smart Pills Dispenser Team</p>" ;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("smartpillsdispenser@gmail.com", senderName);
        helper.setTo(carer.getEmail());
        helper.setSubject(subject);
        helper.setText(mailContent,true);
        mailSender.send(message);
    }

    //Este metodo permite: Actualizar mediante ID
    public Carer update(Integer id, Carer entity) throws Exception {
        try {
            Optional<Carer> entityOptional = carerRepository.findById(id);
            Carer carer = entityOptional.get();
            carer = carerRepository.save(entity);
            return carer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (carerRepository.existsById(id)) {
                carerRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
