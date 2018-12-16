package com.iusofts.blades.job.common.validation;

import com.iusofts.blades.job.exceptions.ScheduleException;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 校验工具类
 */
public class ValidationUtils {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * 校验对象所有属性
	 *
	 * @param obj
	 * @param groups
	 *            分组
	 * @return
	 */
	public static <T> ValidationResult validateEntity(T obj, Class<?>... groups) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = null;
		if (groups != null && groups.length > 0) {
			set = validator.validate(obj, groups);
		} else {
			set = validator.validate(obj, Default.class);
		}
		if (!CollectionUtils.isEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	/**
	 * 校验对象的单个属性
	 *
	 * @param obj
	 * @param propertyName
	 * @return
	 */
	public static <T> ValidationResult validateProperty(T obj, String propertyName, Class<?>... groups) {
		ValidationResult result = new ValidationResult();
		Set<ConstraintViolation<T>> set = null;
		if (groups != null && groups.length > 0) {
			set = validator.validateProperty(obj, propertyName, groups);
		} else {
			set = validator.validateProperty(obj, propertyName, Default.class);
		}
		if (!CollectionUtils.isEmpty(set)) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	/**
	 * 校验对象所有属性
	 *
	 * @param obj
	 * @param groups
	 *            分组
	 * @return true:校验通过
	 */
	public static <T> boolean validate(T obj, Class<?>... groups) {
		ValidationResult result = validateEntity(obj, groups);
		if (result.isHasErrors()) {
			throw new ScheduleException(result.getErrorMsgJson());
		}
		return true;
	}

	/**
	 * 校验对象所有属性
	 *
	 * @param obj
	 * @param otherErrors 其它错误
	 * @param groups
	 *            分组
	 * @return true:校验通过
	 */
	public static <T> boolean validate(T obj,Map<String, String> otherErrors, Class<?>... groups) {
		ValidationResult result = validateEntity(obj,groups);

		// 将其它错误信息汇总到校验结果中
		if (otherErrors != null && otherErrors.size() > 0) {
			result.setHasErrors(true);
			if (result.getErrorMsg() == null) {
				result.setErrorMsg(otherErrors);
			} else {
				result.getErrorMsg().putAll(otherErrors);
			}
		}

		if(result.isHasErrors()){
			throw new ScheduleException(result.getErrorMsgJson());
		}
		return true;
	}

}