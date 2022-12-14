/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Machine;
import com.example.demo.repositories.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;
    
    public List<Machine> getAll(){return machineRepository.getAll();}
    public Optional<Machine> getMachine(int id){return machineRepository.getMachine(id);}
    
    public Machine save(Machine machine){
    if(machine.getId()==null){
        return machineRepository.save(machine);
    }else{
        Optional<Machine> e= machineRepository.getMachine(machine.getId());
        if(e.isEmpty()){
            return machineRepository.save(machine);
        }else{
            return machine;
            }
        }
    }
    //Delete
    public boolean deleteMachine(int id){
        Boolean d = getMachine(id).map(machine ->{
            machineRepository.delete(machine);
            return true;
    }).orElse(false);
        return d;
    }
    
    public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> e= machineRepository.getMachine(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                machineRepository.save(e.get());
                return e.get();
                }else{
                    return machine;
            }
        }else{
            return machine;
        }
    }
    
    /*public List<YearAmount> getTopMachineByYear(){
        
        List<Object[]> report = machineRepository.getTopByYear();
        List<YearAmount> res = new ArrayList<>();
        for(int i=0; i<report.size(); i++){
            res.add(new YearAmount((int)report.get(i)[0], (int) report.get(i)[1]));
        }
        return res;
    }*/
}