package com.make.library.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.make.library.entities.Book;
import com.make.library.services.BookService;

@Controller
//@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books";
    }
    @GetMapping("/viewbook")
    public String showBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        System.out.println(books);
        return "viewbook";
    }
    @PostMapping("/checkAvailability")
    public String checkAvailability(@RequestParam String bookName, @RequestParam String authorName, Model model) {
        boolean isAvailable = bookService.checkAvailability(bookName, authorName);
        model.addAttribute("notAvailable", !isAvailable);
        model.addAttribute("available", isAvailable);
        return "checkavailability";
    }
    
    @PostMapping("/issueBook")
    public String issueBook(@RequestParam String bookName, @RequestParam String authorName,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate issueDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate) {
        // Call the service method to issue the book
        bookService.issueBook(bookName, authorName, issueDate, returnDate);
        return "redirect:/admin/adminhome";
    }
}