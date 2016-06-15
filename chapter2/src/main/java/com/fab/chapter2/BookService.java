/**
 * 
 */
package com.fab.chapter2;

import javax.inject.Inject;

import com.fab.chapter2.qualifiers.ThirteenDigits;

/**
 * @author fahoulou
 *
 */
@Loggable
public class BookService {

	@Inject
	@ThirteenDigits
	private NumberGenerator generator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(generator.generateNumber());
		return book;
	}
}
