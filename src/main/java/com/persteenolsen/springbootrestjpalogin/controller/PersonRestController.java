package com.persteenolsen.springbootrestjpalogin.controller;


import com.persteenolsen.springbootrestjpalogin.model.PersonEntity;

import com.persteenolsen.springbootrestjpalogin.service.PersonService;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
@RequestMapping(value = "/person-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PersonRestController
{
    
    @Autowired
    private PersonService personService;
 
 
    @GetMapping(value = "/persons")
    public List<PersonEntity> getAllPersons() {
      
     return personService.getAll();
    }
 
    @PostMapping("/person")
    PersonEntity createOrSavePerson(@RequestBody PersonEntity newPerson) {
       
        return personService.saveUpdate(newPerson);
    }
 
    @GetMapping("/person/{id}")
    PersonEntity getPersonById(@PathVariable Long id) {
        
        return personService.getPersonById(id);
    }
 
    @PutMapping("/person/{id}")
    PersonEntity updatePerson(@RequestBody PersonEntity newPerson, @PathVariable Long id) {
           PersonEntity person = personService.getPersonById(id);

            person.setName(newPerson.getName());
            person.setEmail(newPerson.getEmail());
            person.setAge(newPerson.getAge());

           return personService.saveUpdate(person);
        
    }
 
    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Long id) {
        
        personService.deletePerson(id);
    }
}