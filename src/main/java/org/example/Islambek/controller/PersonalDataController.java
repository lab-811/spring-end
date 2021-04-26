package org.example.Islambek.controller;

import org.example.Islambek.model.PersonalData;
import org.example.Islambek.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personalDatas")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;


    @GetMapping
    public List<PersonalData> findAll(){
        return personalDataService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PersonalData> findOne(@PathVariable Long id){
        return  personalDataService.findOne(id);
    }

    @PostMapping()
    public void createPersonalData(@RequestBody PersonalData personalData){
        personalDataService.createPersonalData(personalData);
    }

    @PatchMapping("/{id}")
    public void changeUserId(@PathVariable Long id, @RequestParam Long userId){
        personalDataService.ChangeUserId(id, userId);
    }

    @DeleteMapping("/{id}")
    public void deletePersonalData(@RequestParam Long id){
        personalDataService.deletePersonalData(id);
    }
}









