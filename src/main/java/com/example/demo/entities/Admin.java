/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author danie
 */
@Entity
@Table(name="admin")


public class Admin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idAdmin;
    private String nameAdmin;
    private String emailAdmin;
    private String passwordAdmin;

    /**
     * @return the idAdmin
     */
    public Integer getIdAdmin() {
        return idAdmin;
    }

    /**
     * @param idAdmin the idAdmin to set
     */
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    /**
     * @return the nameAdmin
     */
    public String getNameAdmin() {
        return nameAdmin;
    }

    /**
     * @param nameAdmin the nameAdmin to set
     */
    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    /**
     * @return the emailAdmin
     */
    public String getEmailAdmin() {
        return emailAdmin;
    }

    /**
     * @param emailAdmin the emailAdmin to set
     */
    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    /**
     * @return the passwordAdmin
     */
    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    /**
     * @param passwordAdmin the passwordAdmin to set
     */
    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

   
}