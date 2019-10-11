package com.mamatzone.microservice.bookorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamatzone.microservice.bookorders.model.BookOrder;

public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {

}
