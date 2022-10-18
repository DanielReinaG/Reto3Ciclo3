/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.crud.repository;

import com.example.demo.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danie
 */
public interface ReservationCrudRepository  extends CrudRepository<Reservation,Integer>{
    @Query("SELECT c.machine, COUNT(c.machine) from Reservation AS c group by c.machine order by COUNT(c.machine)")
    public List<Object[]> countTotalReservationsByMachine();
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    public List<Reservation>findAllByStatus(String status);
    }
