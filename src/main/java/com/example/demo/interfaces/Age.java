package com.example.demo.interfaces;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 年龄校验注解
 * @author zhouhao
 *
 */
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
	
	String message() default "年龄不能超过{max}岁";
	
	int max() default 5;
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
