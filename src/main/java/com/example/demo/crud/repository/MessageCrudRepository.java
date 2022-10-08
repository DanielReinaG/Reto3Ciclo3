/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.crud.repository;



import com.example.demo.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danie
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    
}