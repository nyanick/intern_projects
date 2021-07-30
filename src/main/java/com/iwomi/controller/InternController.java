/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iwomi.controller;

import com.iwomi.config.JwtTokenUtil;
import com.iwomi.model.Interns;

import com.iwomi.repository.InternsRepo;
import com.iwomi.service.InternService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author HP
 */

@RestController
@CrossOrigin()
public class InternController {
    
    
    @Autowired
    InternsRepo internsRepo;
    
    @Autowired
    InternService internService;
    
    
    @RequestMapping(value = "/getALlInterns", method = RequestMethod.GET)
    public Iterable<Interns> getALlInterns(){
        Iterable<Interns> allinterns = internsRepo.findAll();
        return allinterns;
    }
    
    @RequestMapping(value = "/getAnIntern/{id}", method = RequestMethod.GET)
    public void getAnIntern(@PathVariable Long id){
        internsRepo.findById(id).get();
    }
    
    @RequestMapping(value = "/addInterns", method = RequestMethod.POST)
    public String add(@RequestBody Map<String, String> payload){
        
        /*
        {
            "name":"yan",
            "password":"yanpass",
            "age":"23",
            "level":"1"
        }
        */
        
        String name = payload.get("name");
        String password = payload.get("password");
        int age = Integer.parseInt(payload.get("age"));
        String level = payload.get("level");
        //ID
        
        String response = internService.addIntern(name, password, age, level);
        
        return response;
        
    }

   
}
