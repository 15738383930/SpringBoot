package com.example.demo.validator;

import com.example.demo.interfaces.Sex;
import com.example.demo.utils.CommUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 性别校验器
 * @Author zhou
 * @Date  2019/8/7 14:09
 */
public class SexValidator implements ConstraintValidator<Sex, String> {

	@Override
	public void initialize(Sex sex) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isEmpty(value)){
			//禁用默认的message的值
			context.disableDefaultConstraintViolation();
			//重新添加错误提示语句
			context.buildConstraintViolationWithTemplate("请选择人物性别").addConstraintViolation();
			return false;
		}
		if(CommUtil.Property.SEX_MAN.equals(value) || CommUtil.Property.SEX_WOMAN.equals(value) || CommUtil.Property.SEX_UNKNOWN.equals(value)) {
			return true;
		}
		return false;
	}
}
