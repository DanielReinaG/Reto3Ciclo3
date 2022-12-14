/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.MessageCrudRepository;
import com.example.demo.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class MessageRepository {
    @Autowired
    
   private MessageCrudRepository messageCrudRepository;
   
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message>getMessage(int id){
        return messageCrudRepository.findById(id); 
    }
    
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    //Metodo Delete, void no devuelve nada
    public void delete(Message m){
        messageCrudRepository.delete(m);
    }
}
