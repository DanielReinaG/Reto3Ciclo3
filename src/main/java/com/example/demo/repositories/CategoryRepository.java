/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;



import com.example.demo.crud.repository.CategoryCrudRepository;
import com.example.demo.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class CategoryRepository {
    @Autowired
    
   private CategoryCrudRepository categoryCrudRepository;
   
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id); 
    }
    
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    //Metodo Delete, void no devuelve nada
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }
    
}
