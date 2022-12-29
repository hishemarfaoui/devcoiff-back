package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Entities.Rendez_vous;
import com.example.devcoiff.Entities.Service;
import com.example.devcoiff.Services.IService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    IService iService;

    @PostMapping("/add/{idCoiff}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Service add_New_Service(@RequestBody Service service, @PathVariable Long idCoiff) {
        iService.ajoutService(service,idCoiff);
        return service;
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public List<Service> all_Service(){
        return iService.getAllServices();
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Service  GetService (@PathVariable("id") Integer id){
        return  iService.getService(id);
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String Mise_A_jours_service(@RequestBody  Service service){iService.modifierService(service);
        return "updated";
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public String supp_service(@PathVariable("id") Integer id){iService.supprimerService(id);
        return "removed";}


}
