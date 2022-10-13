/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.AdminCrudRepository;
import com.example.demo.entities.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class AdminRepository {
    @Autowired
    
   private AdminCrudRepository adminCrudRepository;
   
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id); 
    }
    
    public Admin save(Admin a){
        return adminCrudRepository.save(a);
    }
    //Metodo Delete, void no devuelve nada
    public void delete(Admin a){
        adminCrudRepository.delete(a);
    }
}