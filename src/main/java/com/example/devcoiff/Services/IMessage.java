package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IMessage {

    Message ajoutMessage(Message message, Long clientID, Long coiffID);

    public void modifierMessage(Message message);
    public void supprimerMessage(Integer id);
    public Message getMessage(Integer id);
    public List<Message> getAllMessage();
    List<Message> getAllByPair(Long client, Long coiffeur);
}
