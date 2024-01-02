package fr.gorisse.todoApp.TodoListApp.services;

import fr.gorisse.todoApp.TodoListApp.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MailService {
    JavaMailSender javaMailSender;

    public void sendActivationCode(User user){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("no-reply@TodoList.com");
        msg.setTo(user.getEmail().getEmail());
        msg.setSubject("Bienvenue sur TodoList");
        msg.setText("Bonjour "+user.getFirstName()+" "+user.getLastName()+",\n\n" +
                "Nous vous remercions de votre inscription sur TodoList.\n" +
                "Vous pouvez dès à présent vous connecter à votre compte.\n\n" +
                "Votre code de validation est : "+user.getActivationCode()+"\n\n "+
                "Cordialement,\n" +
                "L'équipe TodoList");
        this.javaMailSender.send(msg);
    }
}
