/**
 * 
 */
package com.fab.chapter2.qualifiers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * @author fahoulou
 *
 */
@Qualifier
@Target({FIELD, TYPE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ThirteenDigits {

}
