/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.ReservationCrudRepository;
import com.example.demo.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class ReservationRepository {
    @Autowired
    
   private ReservationCrudRepository reservationCrudRepository;
   
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id); 
    }
    
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }
    //Metodo Delete, void no devuelve nada
    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }
}
