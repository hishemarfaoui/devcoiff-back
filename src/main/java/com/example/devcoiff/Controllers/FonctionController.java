package com.example.devcoiff.Controllers;

import com.example.devcoiff.DTO.NumberFonction;
import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Fonction;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Services.IFonction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/fonctions")
public class FonctionController {
    @Autowired
    IFonction iFonction;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Fonction add_New_Fonction(@RequestBody Fonction fonction) {
        iFonction.ajoutFonction(fonction);
        return  fonction;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public List<Fonction> all_Fonction(){
        return iFonction.getAllFonction();
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public List<NumberFonction> allNumbByFonction() {
        List<Map<String, Object>> myList = iFonction.getAllNumbersByFunctionType();
        List<NumberFonction> myObjectList = new ArrayList<>();

        for (Map<String, Object> map : myList) {
            String functionType = (String) map.get("functionType");
            Number nombre = (Number) map.get("nombre"); // utilise Number au lieu de Integer
            NumberFonction n = new NumberFonction();
            n.setFunctionType(functionType);
            n.setNombre(nombre.intValue()); // convertit la valeur en entier si c'est possible
            myObjectList.add(n);
        }

        return myObjectList;
    }





    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Fonction GetFonction(@PathVariable("id") Integer id){
        return iFonction.getFonction(id);
    }
    @GetMapping("/nom/{nom}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Fonction GetFonctionbynom(@PathVariable("nom") String nom){
        return iFonction.findByNom(nom);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Fonction Mise_A_jours_fonction(@RequestBody Fonction fonction){iFonction.modifierFonction(fonction);
        return fonction;}
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public void supp_fonction(@PathVariable("id") Integer id){
         iFonction.supprimerFonction(id); ;}

}
