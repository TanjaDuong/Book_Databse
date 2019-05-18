package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository) {
	return (args) -> {
		log.info("save a couple of students");
		
		crepository.save(new Category("Fantastic"));
		crepository.save(new Category("Romantic"));
		crepository.save(new Category("Children's books"));
		
		Book book1 = new Book("Game of Throne", "G.G.Martin", 1999, "2111", 50, crepository.findByName("Fantastic").get(0));
		Book book2 = new Book("Lord Of the Ring", "Tolkien", 1990, "2112", 60, crepository.findByName("Fantastic").get(0));
		Book book3 = new Book("The Hobbit", "Tolkien", 1992, "2113", 70, crepository.findByName("Fantastic").get(0));
		Book book4 = new Book("Harry Potter", "J.L.Rowling", 1997, "2114", 70, crepository.findByName("Fantastic").get(0));
		Book book5 = new Book("The Witcher", "Andrzej Sapkowski", 1994, "2114", 90, crepository.findByName("Fantastic").get(0));
		Book book6 = new Book("Twilight", "Stephene", 1992, "2113", 70, crepository.findByName("Fantastic").get(0));
	
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
		repository.save(book5);
		repository.save(book6);
		
		log.info("fetch all students");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}

		
	
	};
	}

}
