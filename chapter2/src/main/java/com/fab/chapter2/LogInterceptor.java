/**
 * 
 */
package com.fab.chapter2;

import java.time.Duration;
import java.time.Instant;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

/**
 * @author fahoulou
 *
 */
@Loggable
@Interceptor
public class LogInterceptor {

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object log(InvocationContext context) throws Exception {
		logger.info("Debut execution {}.{}", context.getTarget().getClass().getName(), context.getMethod().getName());
		Instant start = Instant.now();
		try {
			return context.proceed();
		} finally {
			logger.info("Fin execution {}.{} in {} ms", context.getTarget().getClass().getName(),
					context.getMethod().getName(), Duration.between(start, Instant.now()).abs().toMillis());
		}
	}

}
