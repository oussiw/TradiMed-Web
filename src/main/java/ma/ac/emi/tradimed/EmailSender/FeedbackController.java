package ma.ac.emi.tradimed.EmailSender;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;
import java.util.Properties;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    EmailConfig emailConfig;

    public FeedbackController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @PostMapping
    public void sendEmail(@RequestBody Feedback feedback, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw  new ValidationException("Email is not valid");
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable",emailConfig.getProperties());

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(this.emailConfig.getHost());
        javaMailSender.setPort(this.emailConfig.getPort());
        javaMailSender.setUsername(this.emailConfig.getUsername());
        javaMailSender.setPassword(this.emailConfig.getPassword());
        javaMailSender.setJavaMailProperties(properties);


        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo("alimalaoui3@gmail.com");
        simpleMailMessage.setSubject("Tradimed - New Message from :"+ feedback.getNom()+" "+feedback.getPrenom());
        simpleMailMessage.setText(feedback.getMessage());


        javaMailSender.send(simpleMailMessage);
    }
}
