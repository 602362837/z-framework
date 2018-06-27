package cn.com.zyj.spring.exception;

/**
 * 文件阅读器异常
 * 
 * @author Administrator
 *
 */
public class ResourceReaderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceReaderException(String message, Throwable throwable) {
		super("配置文件阅读器运行发生错误，退出应用:" + message, throwable);
		super.printStackTrace();
		System.exit(0);
	}

	public ResourceReaderException(String message) {
		super("配置文件阅读器运行发生错误，退出应用:" + message);
		super.printStackTrace();
		System.exit(0);
	}

}
