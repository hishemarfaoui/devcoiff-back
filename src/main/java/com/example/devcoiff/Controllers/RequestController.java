package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Request;
import com.example.devcoiff.Services.IRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Request")
public class RequestController {
    @Autowired
    IRequest iRequest;


    @PostMapping("/add")
    @ResponseBody
    public Request add_New_request(@RequestBody Request request) {
        iRequest.ajoutRequest(request);
        return request ;}


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

    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_request(@RequestBody Request request){iRequest.modifierRequest(request);
        return "updated";}


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_request(@PathVariable("id") Long id){iRequest.supprimerRequest(id);
        return "removed";}


}
