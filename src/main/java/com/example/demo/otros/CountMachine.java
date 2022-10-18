/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.otros;

import com.example.demo.entities.Machine;

/**
 *
 * @author danie
 */
public class CountMachine {
    private Long total;
    private Machine machine;
    
    public CountMachine (Long total, Machine machine){
        this.total = total;
        this.machine = machine;
    }

    /**
     * @return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * @return the machine
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     * @param machine the machine to set
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }
    
    
}
