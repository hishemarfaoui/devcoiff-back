package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Créneaux;
import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Services.IDate_de_travail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Dates_de_travail")
public class Date_de_travailController {
    @Autowired
    IDate_de_travail iDate_de_travail;

    @PostMapping("/add")
    @ResponseBody
    public Date_de_travail add_New_Date_travail(@RequestBody Date_de_travail date_de_travail) {
        iDate_de_travail.ajoutDate_travail(date_de_travail);
        return date_de_travail ;
}

    @GetMapping("/all")
    @ResponseBody
    public List<Date_de_travail> all_Dates_de_travail(){
        return iDate_de_travail.getAllDate_travail();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Date_de_travail GetDates_de_travail(@PathVariable("id") Integer id){
        return  iDate_de_travail.getDate_travail(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_date_travail(@RequestBody Date_de_travail date_de_travail){iDate_de_travail.modifierDate_travail(date_de_travail);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_date_travail(@PathVariable("id") Integer id){iDate_de_travail.supprimerDate_travail(id);
        return "removed";}



}
