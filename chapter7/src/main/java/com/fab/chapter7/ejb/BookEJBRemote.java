package com.fab.chapter7.ejb;

import java.util.List;

import com.fab.chapter7.entity.Book;

public interface BookEJBRemote {
	
	List<Book> findBooks();

	Book createBook(Book book);

	void deleteBook(Book book);

	Book updateBook(Book book);
}
