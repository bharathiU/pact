package com.bookshopapp.model.service;

import com.bookshopapp.model.entities.Book;


public interface BookService {
	
	public void deleteBook(Long id);
	public Book addBook(Book book);
	public Book updateBook(Long id,Book book);

}
