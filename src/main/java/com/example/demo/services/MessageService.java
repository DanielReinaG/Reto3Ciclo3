/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Message;
import com.example.demo.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){return messageRepository.getAll();}
    public Optional<Message> getMessage(int id){return messageRepository.getMessage(id);}
    
    public Message save(Message message){
    if(message.getIdMessage()==null){
        return messageRepository.save(message);
    }else{
        Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
        if(e.isEmpty()){
            return messageRepository.save(message);
        }else{
            return message;
            }
        }
    }
    //Delete
    public boolean deleteMessage(int id){
        Boolean d = getMessage(id).map(message ->{
            messageRepository.delete(message);
            return true;
    }).orElse(false);
        return d;
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
                }else{
                    return message;
            }
        }else{
            return message;
        }
    }
}