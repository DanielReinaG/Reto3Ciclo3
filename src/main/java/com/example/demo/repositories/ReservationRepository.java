/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;


import com.example.demo.crud.repository.ReservationCrudRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Machine;
import com.example.demo.entities.Reservation;
import com.example.demo.otros.CountClient;
import com.example.demo.otros.CountMachine;
import java.util.ArrayList;
import java.util.Date;
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
    public List<CountMachine> getTopMachine(){
        List<CountMachine>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByMachine();
        for(int i=0;i<report.size(); i++){
            res.add(new CountMachine((Long)report.get(i)[1],(Machine)report.get(i)[0]));
        }
        return res;
    }
        //RETO5
    public List<CountClient> getTopClients(){
     
        List<CountClient>res=new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1], (Client)report.get(i)[0]));
        }
        return res;
    }
    
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
