package com.packages.spring.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String message () default "{inValid}";
	int lower () default 18;
	int upper()default 60;
	
}
