package com.fab.chapter7;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fab.chapter7.ejb.BookEJBRemote;
import com.fab.chapter7.entity.Book;

public class Main {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		BookEJBRemote bookEJB = (BookEJBRemote) ctx
				.lookup("java:global/chapter7-0.0.1-SNAPSHOT/BookEJB!com.fab.chapter7.BookEJBRemote");
		// Gets and displays all the books from the database
		List<Book> books = bookEJB.findBooks();
		for (Book aBook : books) {
			System.out.println(aBook);
		}
		// Creates an instance of book
		Book book = new Book("H2G2", 12.5F, "Scifi book", "1-24561-799-0", 354, false);
		book = bookEJB.createBook(book);
		System.out.println("Book created : " + book);
		book.setTitle("H2G2");
		book = bookEJB.updateBook(book);
		System.out.println("Book updated : " + book);
		bookEJB.deleteBook(book);
		System.out.println("Book deleted");
	}

}
