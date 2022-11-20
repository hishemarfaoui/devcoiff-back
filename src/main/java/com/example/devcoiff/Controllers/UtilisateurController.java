package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Entities.Service;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Services.IUtilisateur;
import com.example.devcoiff.Services.Iimage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
        @Autowired
    IUtilisateur iUtilisateur;
        @PostMapping("/add/{id}")
        @ResponseBody
        public Utilisateur add_New_Utilisateur(@RequestBody Utilisateur utilisateur,@PathVariable("id") Integer id) {
            iUtilisateur.ajoutUtilisateur(utilisateur,id);
            return  utilisateur;
        }
    @GetMapping("/all")
    @ResponseBody
    public List<Utilisateur> all_Utilisateur(){
        return iUtilisateur.getAllUtilisateur();
    }
    @GetMapping("/id/{id}")
    @ResponseBody
    public Utilisateur GetUtilisateur(@PathVariable("id") int id){
        return  iUtilisateur.getUtilisateur(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_utilisateur(@RequestBody Utilisateur utilisateur){iUtilisateur.modifierUtlisateur(utilisateur);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_utilisateur(@PathVariable("id") Integer id){iUtilisateur.supprimerUtlisateur(id);
        return "removed";}

    @GetMapping("/get-service/{idCoiff}")
    @ResponseBody
    public List<Service> getServicesByUser(@PathVariable Integer idCoiff){
        return iUtilisateur.getServicesByUser(idCoiff);
    }

}
