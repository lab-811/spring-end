package org.example.Islambek.service;

import org.example.Islambek.model.PersonalData;
import org.example.Islambek.repositories.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDataService {


    @Autowired
    private PersonalDataRepository personalDataRepository;


    public List<PersonalData> findAll(){
        return personalDataRepository.findAll();
    }

    public Optional<PersonalData> findOne(Long id){
        return personalDataRepository.findById(id);
    }

    public void createPersonalData(PersonalData personalData) {

        PersonalData newPersonalData = new PersonalData();
        newPersonalData.setFullName(personalData.getFullName());
        newPersonalData.setPhoneNumber(personalData.getPhoneNumber());
        personalDataRepository.save(newPersonalData);

    }

    public void ChangeUserId(Long id, Long userId){

        PersonalData personalData = personalDataRepository.findById(id).get();
        personalData.setUser_id(userId);
        personalDataRepository.saveAndFlush(personalData);

    }

    public void deletePersonalData(Long id) {
        personalDataRepository.deleteById(id);
    }






}
