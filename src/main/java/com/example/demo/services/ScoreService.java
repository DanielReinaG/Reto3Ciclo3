/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Score;
import com.example.demo.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){return scoreRepository.getAll();}
    public Optional<Score> getScore(int id){return scoreRepository.getScore(id);}
    
    public Score save(Score score){
    if(score.getIdScore()==null){
        return scoreRepository.save(score);
    }else{
        Optional<Score> e= scoreRepository.getScore(score.getIdScore());
        if(e.isEmpty()){
            return scoreRepository.save(score);
        }else{
            return score;
            }
        }
    }
    //Delete
    public boolean deleteScore(int id){
        Boolean d = getScore(id).map(score ->{
            scoreRepository.delete(score);
            return true;
    }).orElse(false);
        return d;
    }
    
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> e= scoreRepository.getScore(score.getIdScore());
            if(!e.isEmpty()){
                if(score.getStarts()!=null){
                    e.get().setStarts(score.getStarts());
                }
                if(score.getMessageText()!=null){
                    e.get().setMessageText(score.getMessageText());
                }
                
                scoreRepository.save(e.get());
                return e.get();
                }else{
                    return score;
            }
        }else{
            return score;
        }
    }
}
