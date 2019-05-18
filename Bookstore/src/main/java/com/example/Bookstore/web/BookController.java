package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; 
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    } 
	
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
		 //content of the method is completely empty new object
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", crepository.findAll()); 
	    	//go to new html-end-point
	        return "addbook";
	    } 
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    } 
	}


