package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Services.IRendez_vous;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rendez_vous")
public class Rendez_vousController {
    @Autowired
    IRendez_vous iRendez_vous;

    @PostMapping("/add/{id}/{idcl}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Rendez_vous add_New_Rendez_vous(@RequestBody Rendez_vous rendez_vous,@PathVariable("id") Long id,@PathVariable("idcl") Long idcl) {
        iRendez_vous.ajoutRV(rendez_vous, id,idcl);
        return rendez_vous ;
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public List<Rendez_vous> all_Rendez_vous(){
        return iRendez_vous.getAllRV();
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Rendez_vous GetRendez_vous(@PathVariable("id") Integer id){
        return  iRendez_vous.getRV(id);
    }


    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String Mise_A_jours_rendez_vous(@RequestBody Rendez_vous rendez_vous){iRendez_vous.modifierRV(rendez_vous);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String supp_rendez_vous(@PathVariable("id") Integer id){iRendez_vous.supprimerRV(id);
        return "removed";}

    @GetMapping("/get-dispo/{idCoiff}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public List<Rendez_vous> findDipso(@PathVariable Integer idCoiff){

        return iRendez_vous.findDispo(idCoiff);
    }
    @PutMapping("/accept/{idRdv}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Rendez_vous acceptrv(@PathVariable Integer idRdv){
        return   iRendez_vous.accepterRV(idRdv);
    }

    @PutMapping("/refuse/{idRdv}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Rendez_vous refuserv(@PathVariable Integer idRdv){
        return  iRendez_vous.reffuserRV(idRdv);
    }

    }







