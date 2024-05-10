package com.make.library.services;

import java.time.LocalDate;
import java.util.List;

import com.make.library.entities.Book;


public interface BookService {
	
    public List<Book> getAllBooks();
    void addBook(Book book);
	boolean checkAvailability(String bookName, String authorName);
	public void issueBook(String bookName, String authorName, LocalDate issueDate, LocalDate returnDate);
	

}
