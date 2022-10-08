/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;


import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author danie
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){return adminRepository.getAll();}
    public Optional<Admin> getAdmin(int id){return adminRepository.getAdmin(id);}
    
    public Admin save(Admin admin){
    if(admin.getIdAdmin()==null){
        return adminRepository.save(admin);
    }else{
        Optional<Admin> e= adminRepository.getAdmin(admin.getIdAdmin());
        if(e.isEmpty()){
            return adminRepository.save(admin);
        }else{
            return admin;
            }
        }
    }
    
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> e= adminRepository.getAdmin(admin.getIdAdmin());
            if(!e.isEmpty()){
                if(admin.getNameAdmin()!=null){
                    e.get().setNameAdmin(admin.getNameAdmin());
                }
                if(admin.getEmailAdmin()!=null){
                    e.get().setEmailAdmin(admin.getEmailAdmin());
                }
                if(admin.getPasswordAdmin()!=null){
                    e.get().setPasswordAdmin(admin.getPasswordAdmin());
                }
                adminRepository.save(e.get());
                return e.get();
                }else{
                    return admin;
            }
        }else{
            return admin;
        }
    }
}
