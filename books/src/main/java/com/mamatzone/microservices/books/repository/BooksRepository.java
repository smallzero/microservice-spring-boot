package com.mamatzone.microservices.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mamatzone.microservices.books.model.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
	@Query("SELECT b FROM Book b")
	List<Book> findAllBooks();
	
	@Query("SELECT b FROM Book b WHERE UPPER(b.title) like :title")
	List<Book> findBookByTitle(@Param("title")String title);
}
