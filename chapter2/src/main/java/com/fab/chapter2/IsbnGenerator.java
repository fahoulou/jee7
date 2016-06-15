/**
 * 
 */
package com.fab.chapter2;

import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.fab.chapter2.qualifiers.ThirteenDigits;

/**
 * @author fahoulou
 *
 */
@Loggable
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fab.chapter2.NumberGenerator#generateNumber()
	 */
	@Override
	public String generateNumber() {
		String isbn = "13-84356-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN : {}", isbn);
		return isbn;
	}

}
