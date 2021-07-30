/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwomi.service;

import com.iwomi.model.Interns;
import com.iwomi.repository.InternsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class InternService {
    @Autowired
    InternsRepo internsRepo;
    
    
    public String addIntern(String name, String password, int age, String level){
        
        Interns intern = new Interns(name,password, age, level);
        
        Interns saved_intern = internsRepo.save(intern);
        
        return "ok";
    }
    
}
