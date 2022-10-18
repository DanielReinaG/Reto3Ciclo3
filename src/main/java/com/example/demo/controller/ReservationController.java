/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;


import com.example.demo.entities.Reservation;
import com.example.demo.otros.CountClient;
import com.example.demo.otros.CountMachine;
import com.example.demo.otros.StatusAmount;
import com.example.demo.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins ="*", methods={RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id")int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation mostrar){
        return reservationService.save(mostrar);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservationService.deleteReservation(id);
    }
    
    //RETO5
    @GetMapping("/report-machines")
    public List<CountMachine> getReservationsReportMachine(){
        return reservationService.getTopMachine();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservationService.getTopClients();    
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo") String dateTwo){
            return reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    
    /*@GetMapping("/report-dates/amount/(dateOne)/(dateTwo)")
    public Integer getReservationsReportDatesAmount (@PathVariable("dateOne")String dateOne,@PathVariable("dateTwo") String dateTwo){
            return reservationService.getReservationsPeriod(dateOne, dateTwo).size();
    }*/
    
    @GetMapping("/report-status")
    public StatusAmount getReservationReportStatus(){
        return reservationService.getReservationsStatusReport();
    }
}
