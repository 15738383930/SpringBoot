package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.interfaces.Age;

/**
 * 年龄校验器
 * @Author zhou
 * @Date  2019/8/7 14:09
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {
	
	Age age;
	
	int max;

	/**
	 * 获取注解的值
	 * @param age
	 */
	@Override
	public void initialize(Age age) {
		this.age = age;
		max = age.max();
	}

	/**
	 * 注解校验
	 * @param value 被注解的属性的value
	 * @param context 注解错误提示对象
	 */
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return value < max;
	}
}
