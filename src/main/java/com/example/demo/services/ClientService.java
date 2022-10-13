/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){return clientRepository.getAll();}
    public Optional<Client> getClient(int id){return clientRepository.getClient(id);}
    
    public Client save(Client client){
    if(client.getIdClient()==null){
        return clientRepository.save(client);
    }else{
        Optional<Client> e= clientRepository.getClient(client.getIdClient());
        if(e.isEmpty()){
            return clientRepository.save(client);
        }else{
            return client;
            }
        }
    }
    //Delete
    public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client ->{
            clientRepository.delete(client);
            return true;
    }).orElse(false);
        return d;
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                clientRepository.save(e.get());
                return e.get();
                }else{
                    return client;
            }
        }else{
            return client;
        }
    }
}
