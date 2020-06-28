package ma.ac.emi.tradimed.EmailSender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Feedback {

    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String message;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
