package com.iusofts.blades.job.common.validation.annotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private PhoneMode phoneMode;

	public void initialize(Phone constraintAnnotation) {
		this.phoneMode = constraintAnnotation.value();
	}

	public boolean isValid(String object,
			ConstraintValidatorContext constraintContext) {
		if (!StringUtils.isEmpty(object))
			return true;
		boolean flag = false;
		String reg = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})|((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$";
		if (phoneMode == PhoneMode.MOBILE) {
			reg = "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$";
		} else if (phoneMode == PhoneMode.PHONE) {
			reg = "^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$";
		}
		try {
			Pattern regex = Pattern.compile(reg);
			Matcher matcher = regex.matcher(object);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}