package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Services.CreneauxServiceImpl;
import com.example.devcoiff.Services.ICréneau;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/creneaux")
public class CréneauxController {
    @Autowired
     ICréneau iCréneau;

    @PostMapping("/add")
    @ResponseBody
    public Créneaux add_New_Creneau(@RequestBody Créneaux créneaux) {
       iCréneau.ajoutCreneau(créneaux);
        return créneaux ;


}
    @GetMapping("/all")
    @ResponseBody
    public List<Créneaux> all_Creneaux(){
        return iCréneau.getAllCreneau();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Créneaux GetCreneau(@PathVariable("id") Integer id){
        return iCréneau.getCreneau(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_Creneau(@RequestBody Créneaux créneaux){iCréneau.modifierCreneau(créneaux);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_Creneau(@PathVariable("id") Integer id){iCréneau.supprimerCreneau(id);
        return "removed";}

}
