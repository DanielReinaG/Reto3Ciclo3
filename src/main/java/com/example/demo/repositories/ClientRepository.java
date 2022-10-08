/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.ClientCrudRepository;
import com.example.demo.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class ClientRepository {
    @Autowired
    
   private ClientCrudRepository clientCrudRepository;
   
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id); 
    }
    
    public Client save(Client cl){
        return clientCrudRepository.save(cl);
    }
}