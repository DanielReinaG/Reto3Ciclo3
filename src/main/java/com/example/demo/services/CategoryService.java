/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class CategoryService {
    @Autowired

    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category guardar){
    if(guardar.getId()==null){
        return categoryRepository.save(guardar);
    }else{
        Optional<Category> e= categoryRepository.getCategory(guardar.getId());
        if(e.isEmpty()){
            return categoryRepository.save(guardar);
        }else{
            return guardar;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> e= categoryRepository.getCategory(category.getId());
            if(!e.isEmpty()){
                if(category.getName()!=null){
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    e.get().setDescription(category.getDescription());
                }
                categoryRepository.save(e.get());
                return e.get();
                }else{
                    return category;
            }
        }else{
            return category;
        }
    }
}