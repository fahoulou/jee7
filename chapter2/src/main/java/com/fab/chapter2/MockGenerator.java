/**
 * 
 */
package com.fab.chapter2;

import java.util.Random;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.fab.chapter2.qualifiers.ThirteenDigits;

/**
 * @author fahoulou
 *
 */
@Loggable
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	/* (non-Javadoc)
	 * @see com.fab.chapter2.NumberGenerator#generateNumber()
	 */
	@Override
	public String generateNumber() {
		String mock = "MOCK-" + Math.abs(new Random().nextInt());
		logger.info("Generated Mock : " + mock);
		return mock;
	}

}
