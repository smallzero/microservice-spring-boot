package com.mamatzone.microservice.bookorders.resources;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamatzone.microservice.bookorders.model.BookOrder;
import com.mamatzone.microservice.bookorders.repository.BookOrderRepository;

@RestController
@RequestMapping("/rest/orders")
public class BookOrderServiceResource {
	@Autowired
	private BookOrderRepository bookOrderRepository;
	
	@GetMapping("/")
	public List<BookOrder> getAllOrders(){
		return bookOrderRepository.findAll();
	}
	
	@GetMapping("/{orderId}")
	public Optional<BookOrder> getOrderById(@PathParam("orderId") final Long orderId) {
		return bookOrderRepository.findById(orderId);
	}
	
	@PostMapping("/")
	public BookOrder add(@RequestBody final BookOrder bookOrder) {
		bookOrder.setDtOrder(new Date());
		return bookOrderRepository.save(bookOrder);
	}
}
