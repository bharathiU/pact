package com.bookshopapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshopapp.exceptionhandler.BookNotFoundEx;
import com.bookshopapp.model.entities.Book;
import com.bookshopapp.model.repository.BookRepo;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo bookRepo;


	

	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
		
	}

	@Override
	public Book updateBook(Long id, Book book) {
		Book bookToBeUpdated=bookRepo.findById(id).orElseThrow(BookNotFoundEx::new);
		bookToBeUpdated.setBookPrice(book.getBookPrice());
		return bookRepo.save(bookToBeUpdated);
	}
}
