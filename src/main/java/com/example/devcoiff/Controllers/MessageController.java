package com.example.devcoiff.Controllers;

import com.example.devcoiff.Entities.Date_de_travail;
import com.example.devcoiff.Entities.Image;
import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Services.IMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    IMessage iMessage;

    @PostMapping("/add")
    @ResponseBody
    public Message add_New_Message(@RequestBody Message message) {
        iMessage.ajoutMessage(message);
        return message ;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Message> all_Message(){
        return iMessage.getAllMessage();
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public Message GetMessage(@PathVariable("id") Integer id){
        return  iMessage.getMessage(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public String Mise_A_jours_message(@RequestBody Message message){iMessage.modifierMessage(message);
        return "updated";}

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String supp_message(@PathVariable("id") Integer id){iMessage.supprimerMessage(id);
        return "removed";}





}
