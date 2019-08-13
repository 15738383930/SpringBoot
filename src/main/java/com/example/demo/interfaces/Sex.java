package com.example.demo.interfaces;


import com.example.demo.validator.SexValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 性别校验注解
 * @author zhouhao
 *
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {SexValidator.class})
public @interface Sex {
	
	String message() default "人物性别仅限于【男、女、未知】";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
