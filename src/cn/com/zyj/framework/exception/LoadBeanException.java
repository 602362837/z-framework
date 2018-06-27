package cn.com.zyj.framework.exception;

public class LoadBeanException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadBeanException(String beanId, String operationClass) {
		super("load bean error,not find bean【" + beanId + "】 in class【" + operationClass + "】");
	}

	public LoadBeanException(String beanId) {
		super("load bean error,not find bean【" + beanId + "】");
	}
}
