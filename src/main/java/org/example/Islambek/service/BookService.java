package org.example.Islambek.service;

import org.example.Islambek.model.Book;
import org.example.Islambek.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void updateBook(Long id, Book book ) {
        Book bookDb = bookRepository.findById(id).orElse(null);

        if (bookDb != null) {
            bookDb.setTitle(book.getTitle());
            bookDb.setAuthor(book.getAuthor());
            bookRepository.saveAndFlush(bookDb);
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public void createBook(Book book ) {

        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());

        bookRepository.saveAndFlush(newBook);

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }





}










