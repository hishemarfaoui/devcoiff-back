package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Services.IRendez_vous;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rendez_vous")
public class Rendez_vousController {
    @Autowired
    IRendez_vous iRendez_vous;

    @PostMapping("/add/{id}/{idcl}")
    @ResponseBody
    public Rendez_vous add_New_Rendez_vous(@RequestBody Rendez_vous rendez_vous,@PathVariable("id") Integer id,@PathVariable("idcl") Integer idcl) {
        iRendez_vous.ajoutRV(rendez_vous, id,idcl);
        return rendez_vous ;
    }
    @GetMapping("/all")
    @ResponseBody
    public List<Rendez_vous> all_Rendez_vous(){
        return iRendez_vous.getAllRV();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Rendez_vous GetRendez_vous(@PathVariable("id") Integer id){
        return  iRendez_vous.getRV(id);
    }


    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_rendez_vous(@RequestBody Rendez_vous rendez_vous){iRendez_vous.modifierRV(rendez_vous);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_rendez_vous(@PathVariable("id") Integer id){iRendez_vous.supprimerRV(id);
        return "removed";}







}
