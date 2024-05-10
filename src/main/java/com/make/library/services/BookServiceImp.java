package com.make.library.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.library.entities.Book;
import com.make.library.repo.BookRepository;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    @Override
    public boolean checkAvailability(String bookName, String authorName) {
        Optional<Book> bookOptional = bookRepository.findByNameAndAuthorName(bookName, authorName);
        return bookOptional.isPresent(); // Return true if the book is present in the database
    }
    @Override
    public void issueBook(String bookName, String authorName, LocalDate issueDate, LocalDate returnDate) {
        Optional<Book> bookOptional = bookRepository.findByNameAndAuthorName(bookName, authorName);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setIssueDate(issueDate);
            book.setReturnDate(returnDate);
            // Set deadline as 15 days from the issue date
            LocalDate deadline = issueDate.plusDays(15);
            book.setDeadline(deadline);
            bookRepository.save(book);
        }
    }
    
}

