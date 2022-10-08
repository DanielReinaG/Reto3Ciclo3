/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.ScoreCrudRepository;
import com.example.demo.entities.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class ScoreRepository {
    @Autowired
    
   private ScoreCrudRepository scoreCrudRepository;
   
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score>getScore(int id){
        return scoreCrudRepository.findById(id); 
    }
    
    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }
}