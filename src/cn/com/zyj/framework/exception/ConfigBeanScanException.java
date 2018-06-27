package cn.com.zyj.framework.exception;

/**
 * 扫描配置bean异常类
 * 
 * @author mm
 *
 */
public class ConfigBeanScanException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConfigBeanScanException(String message) {
		super(message);
	}
}
