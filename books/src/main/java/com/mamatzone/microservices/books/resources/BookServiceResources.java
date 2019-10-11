package com.mamatzone.microservices.books.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamatzone.microservices.books.model.Book;
import com.mamatzone.microservices.books.repository.BooksRepository;

@RestController
@RequestMapping("/rest/books")
public class BookServiceResources {
	
	@Autowired
	private BooksRepository booksRepository;
		
	@GetMapping("/")
	public List<Book> getBooks(){
		return booksRepository.findAll();
	}
	
	@PostMapping("/")
	public Book add(@RequestBody final Book book) {
		Book resp = booksRepository.save(book);
		return resp;
	}
	
	@GetMapping("/{title}")
	public List<Book> getBooksByTitle(@PathVariable("title")final String title){
		return booksRepository.findBookByTitle("%"+title.toUpperCase()+"%");
	}
	
}
