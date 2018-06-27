package cn.com.zyj.spring.exception;

/**
 * 类扫描器异常
 * 
 * @author mm
 *
 */
public class BeanScanException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BeanScanException(String message) {
		super(message);
	}

	public BeanScanException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
