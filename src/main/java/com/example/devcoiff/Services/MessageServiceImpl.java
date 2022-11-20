package com.example.devcoiff.Services;

import com.example.devcoiff.Entities.Message;
import com.example.devcoiff.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements IMessage{
    @Autowired
    MessageRepository messageRepository;
    @Override
    public Message ajoutMessage(Message message) {
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
}
