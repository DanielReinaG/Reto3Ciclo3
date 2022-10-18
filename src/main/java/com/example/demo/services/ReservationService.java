/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Reservation;
import com.example.demo.otros.CountClient;
import com.example.demo.otros.CountMachine;
import com.example.demo.otros.StatusAmount;
import com.example.demo.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){return reservationRepository.getAll();}
    public Optional<Reservation> getReservation(int id){return reservationRepository.getReservation(id);}
    
    public Reservation save(Reservation reservation){
    if(reservation.getIdReservation()==null){
        return reservationRepository.save(reservation);
    }else{
        Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
        if(e.isEmpty()){
            return reservationRepository.save(reservation);
        }else{
            return reservation;
            }
        }
    }
    //Delete
    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation ->{
            reservationRepository.delete(reservation);
            return true;
    }).orElse(false);
        return d;
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                
                reservationRepository.save(e.get());
                return e.get();
                }else{
                    return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    //RETO5
    public List<CountMachine> getTopMachine(){
        return reservationRepository.getTopMachine();
    }
    
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }
    
    public StatusAmount getReservationsStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
            return new StatusAmount(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        }else{
            return new ArrayList<>();
        }
    }
    
    
    
    
}
