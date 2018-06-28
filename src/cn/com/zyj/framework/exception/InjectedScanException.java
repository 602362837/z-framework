package cn.com.zyj.framework.exception;

/**
 * 注入扫描器异常
 * 
 * @author Administrator
 *
 */
public class InjectedScanException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InjectedScanException(String message, Throwable throwable) {
		super("注入扫描器发生严重错误，应用退出" + message, throwable);
		printStackTrace();
		System.exit(0);
	}

}
