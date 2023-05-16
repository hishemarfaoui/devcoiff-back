package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Request;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Payloads.Mail.Mail;
import com.example.devcoiff.Services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    IRequest iRequest;
    @Autowired
    FonctionServiceImpl fonctionService;
    @Autowired
    MailService mailService;
    @Autowired
    IUtilisateur iUtilisateur;


    @PostMapping("/add")
    @ResponseBody
    public Request add_New_request(@RequestBody Request request) {
        iRequest.ajoutRequest(request);
        return request ;}
    @PostMapping("/accept")
    @ResponseBody
    public Request accept_request(@RequestBody Request request) throws MessagingException {
        Fonction fonction = fonctionService.findByNom(request.getRequestFonction());
        if (fonction!=null){
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setEmail(request.getEmail());
            utilisateur.setFonction(fonction);
            utilisateur.setUsername(generate(8));
            String password =generate(10);
            utilisateur.setPassword(password);
            iUtilisateur.ajoutUtilisateur(utilisateur,fonction.getId_fonction());
            String mailMessage = String.format("Votre password est %s \nVotre username est %s et \nvotre fonction est : %s",
                    password, utilisateur.getUsername(), fonction.getNom());

            Mail mail = new Mail();
            mail.setMailAddress(request.getEmail());
            mail.setMailMessage(mailMessage);
            mail.setMailSubject("Demande Confirmé");
            mailService.sendMail(mail);
            iRequest.supprimerRequest(request.getId_req());



        }else{
            Fonction fonction1 = new Fonction();
            fonction1.setNom(request.getRequestFonction());
            fonctionService.ajoutFonction(fonction1);
            Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1.setEmail(request.getEmail());
            utilisateur1.setFonction(fonction1);
            utilisateur1.setUsername(generate(8));
            String password =generate(10);
            utilisateur1.setPassword(password);
            iUtilisateur.ajoutUtilisateur(utilisateur1,fonction1.getId_fonction());
            String mailMessage = String.format("Votre password est %s \nVotre username est %s et \nvotre fonction est : %s",
                    password, utilisateur1.getUsername(), fonction1.getNom());

            Mail mail1 = new Mail();
            mail1.setMailAddress(request.getEmail());
            mail1.setMailMessage(mailMessage);
            mail1.setMailSubject("Demande Confirmé");
            mailService.sendMail(mail1);
            iRequest.supprimerRequest(request.getId_req());


        }

        return request ;}
    @PostMapping("/refuse")
    @ResponseBody
    public Request refuse_request(@RequestBody Request request) throws MessagingException {
        Mail mail1 = new Mail();
        mail1.setMailAddress(request.getEmail());
        String mailMessage = "Cher Monieur,\n\nNous sommes désolés de vous informer que votre demande de compte n'a pas été acceptée à cause d'un ou des raisons bien spécifiques. Si vous avez besoin de plus d'informations, veuillez contacter notre administrateur à l'adresse suivante : hichem.arfaoui@tek-up.de.\n\nCordialement,\nL'équipe de Hichem Arfaoui";
        mail1.setMailMessage(mailMessage);
        mail1.setMailSubject("Demande Refusé");
        mailService.sendMail(mail1);
        iRequest.supprimerRequest(request.getId_req());
        return request;
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Request> all_request(){
        return iRequest.getAllRequest();
    }


    @GetMapping("/id/{id}")
    @ResponseBody
    public Request GetRequest(@PathVariable("id") Long id){
        return  iRequest.getRequest(id);
    }
    @GetMapping("/count")
    public Long GetRequest(){
        return  iRequest.count();
    }


    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_request(@RequestBody Request request){iRequest.modifierRequest(request);
        return "updated";}


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_request(@PathVariable("id") Long id){iRequest.supprimerRequest(id);
        return "removed";}
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generate(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }


}
