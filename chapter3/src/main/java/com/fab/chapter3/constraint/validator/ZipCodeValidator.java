package com.fab.chapter3.constraint.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.fab.chapter3.constraint.ZipCode;
import com.fab.chapter3.constraint.validator.util.ZipCodeChecker;
import com.fab.chapter3.qualifier.USA;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
	
	@Inject @USA
	private ZipCodeChecker checker;
	private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

	@Override
	public void initialize(ZipCode constraintAnnotation) {	
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		Matcher m = zipPattern.matcher(value);
		if (!m.matches()) return false;
		return checker.isZipCodeValid(value);
	}

}
