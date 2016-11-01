package com.fab.chapter7.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Test;

import com.fab.chapter7.ejb.BookEJB;
import com.fab.chapter7.entity.Book;

public class BookEJBIT {

	@Test
	public void shouldCreateABook() throws Exception {
		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));
		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
			Context ctx = ec.getContext();
			// Check JNDI dependencies (Datasource and EJBs)
			assertNotNull(ctx.lookup("java:global/jdbc/chapter08DS"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!com.fab.chapter7.ejb.BookEJBRemote"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!com.fab.chapter7.ejb.BookEJB"));
			// Looks up the EJB
			BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!com.fab.chapter7.ejb.BookEJB");
			// Finds all the books and makes sure there are two (inserted by the
			// DBPopulator)
			assertEquals(2, bookEJB.findBooks().size());
			// Creates an instance of book
			Book book = new Book("H2G2", 12.5F, "Scifi book", "1-24561-799-0", 354, false);
			// Persists the book to the database
			book = bookEJB.createBook(book);
			assertNotNull("ID should not be null", book.getId());
			// Finds all the books and makes sure there is an extra one
			assertEquals(3, bookEJB.findBooks().size());
			// Removes the created book
			bookEJB.deleteBook(book);
			// Finds all the books and makes sure there is one less
			assertEquals(2, bookEJB.findBooks().size());
		}
	}
}
