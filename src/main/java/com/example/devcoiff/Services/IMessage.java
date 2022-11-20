package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IMessage {
    public Message ajoutMessage(Message message);
    public void modifierMessage(Message message);
    public void supprimerMessage(Integer id);
    public Message getMessage(Integer id);
    public List<Message> getAllMessage();
}
