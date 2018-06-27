package cn.com.zyj.framework.exception;

public class ThreadHelperException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThreadHelperException(String message) {
		super("创建工作线程出现错误:" + message);
	}

}
