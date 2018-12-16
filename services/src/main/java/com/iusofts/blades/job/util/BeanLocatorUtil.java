package com.iusofts.blades.job.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanLocatorUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;

	@Override

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (BeanLocatorUtil.applicationContext == null) {
			BeanLocatorUtil.applicationContext = applicationContext;
		}
	}

	/**
	 * 获取applicationContext
	 *
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 通过name获取 Bean
	 *
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getApplicationContext() != null ? getApplicationContext().getBean(name) : null;
	}

	/**
	 * 通过class获取Bean
	 *
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext() != null ? getApplicationContext().getBean(clazz) : null;
	}

	/**
	 * 通过name,以及Clazz返回指定的Bean
	 *
	 * @param name
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext() != null ? getApplicationContext().getBean(name, clazz) : null;
	}
}
