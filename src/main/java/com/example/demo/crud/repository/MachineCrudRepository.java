/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.crud.repository;


import com.example.demo.entities.Machine;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author danie
 */
public interface MachineCrudRepository extends CrudRepository<Machine,Integer>{
    
    @Query ("SELECT c.year, COUNT(c.year) from Machine AS c group by c.year order by COUNT(c.year) DESC")
    public List<Object[]> countTotalMachinesByYear();
}