package org.example.Islambek.controller;

import org.example.Islambek.model.Issued;
import org.example.Islambek.service.IssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issueds")
public class IssuedController {

    @Autowired
    private IssuedService issuedService;

    @GetMapping
    public List<Issued> getAll(){
        return issuedService.getAll();
    }

    @PostMapping("/create")
    public void issueBook(@RequestParam Long bookId, Long userId){



        issuedService.createIssued(bookId, userId);
    }
}























