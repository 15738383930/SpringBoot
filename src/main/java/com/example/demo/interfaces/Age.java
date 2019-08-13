package com.example.demo.interfaces;


import com.example.demo.utils.CommUtil;
import com.example.demo.validator.AgeValidator;

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
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AgeValidator.class})
public @interface Age {
	
	String message() default "年龄不能超过{max}岁";
	
	int max() default CommUtil.Property.AGE_MAX_DEFAULT;
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
