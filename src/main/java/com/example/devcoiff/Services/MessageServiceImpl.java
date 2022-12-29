package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Entities.Utilisateur;
import com.example.devcoiff.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements IMessage{
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    IUtilisateur iUtilisateur;

    @Override
    public Message ajoutMessage(Message message, Long clientID, Long coiffID) {
        Utilisateur client = iUtilisateur.getUtilisateur(clientID);
        Utilisateur coiffeur = iUtilisateur.getUtilisateur(coiffID);
        message.setUtilisateur(client);
        message.setUtilisateurs(coiffeur);
        message.setTimestamp(new Date());
        return messageRepository.save(message) ;
    }

    @Override
    public void modifierMessage(Message message) {
        messageRepository.save(message);

    }

    @Override
    public void supprimerMessage(Integer id) {
        messageRepository.deleteById(id);

    }

    @Override
    public Message getMessage(Integer id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAllByPair(Long clientID, Long coiffeurID){
        Utilisateur client = iUtilisateur.getUtilisateur(clientID);
        Utilisateur coiffeur = iUtilisateur.getUtilisateur(coiffeurID);
//        Map<String, Integer> messagesContent = new LinkedHashMap<>();
        List<Message> messageList = new ArrayList<>(messageRepository.findAllByUtilisateurAndUtilisateurs(client, coiffeur));

//        for (Message m : messageList) {
//            messagesContent.put(m.getContenu() , m.getSender());
//        }
        return messageList;
    }
}
