package org.example.Islambek.service;

import org.example.Islambek.exception.IncorrectIdException;
import org.example.Islambek.model.Book;
import org.example.Islambek.model.Issued;
import org.example.Islambek.model.User;
import org.example.Islambek.repositories.BookRepository;
import org.example.Islambek.repositories.IssuedRepository;
import org.example.Islambek.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedService {

    @Autowired
    private IssuedRepository issuedRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Issued> getAll() {
        return issuedRepository.findAll();
    }

    public void createIssued(Long bookId, Long userId) {
        if (userId == 0 || bookId == 0) {
            throw new IncorrectIdException("userId or bookId can't be equal to zero(0)");
        }

        Book product = bookRepository.findById(bookId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);


        if (product != null && user != null) {
            Issued issued = new Issued();
            issued.setBookId(bookId);
            issued.setUserId(userId);
            issuedRepository.saveAndFlush(issued);
        }
    }

}





















