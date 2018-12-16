package com.iusofts.blades.job.common.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
/**
 * 电话校验
 */
public @interface Phone {
	String message() default "电话格式不正确";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	PhoneMode value();
}