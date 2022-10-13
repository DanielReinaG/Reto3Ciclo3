/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.crud.repository.MachineCrudRepository;
import com.example.demo.entities.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class MachineRepository {
    @Autowired
    
    private MachineCrudRepository machineCrudRepository;
    
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    
    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }
    
    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }
    
    public void delete(Machine machine){
        machineCrudRepository.delete(machine);
    }
 
}