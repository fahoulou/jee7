package com.fab.chapter7.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

import com.fab.chapter7.entity.Book;

@Remote
public interface BookEJBRemote {

	@NotNull
	Book createBook(@NotNull Book book);

	void deleteBook(@NotNull Book book);

	@NotNull
	Book updateBook(@NotNull Book book);

	List<Book> findBooks();
}
