/**
 * 
 */
package com.fab.chapter2;

import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.fab.chapter2.qualifiers.EightDigits;

/**
 * @author fahoulou
 *
 */
@Loggable
@EightDigits
public class IssnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fab.chapter2.NumberGenerator#generateNumber()
	 */
	@Override
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN : {}", issn);
		return issn;
	}

}
