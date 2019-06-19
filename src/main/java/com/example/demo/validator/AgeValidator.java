package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.interfaces.Age;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
	
	Age age;
	
	int max;
	
	public void initialize(Age age) {
		this.age = age;
		max = age.max();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return value < max;
	}

	
}
