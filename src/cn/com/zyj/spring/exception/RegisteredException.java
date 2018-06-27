package cn.com.zyj.spring.exception;

/**
 * 注册bean异常
 * 
 * @author mm
 *
 */
public class RegisteredException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 注册bean出现异常直接停止应用
	 * 
	 * @param message
	 */
	public RegisteredException(String message) {
		super("注册bean时发生严重错误，应用退出:" + message);
		super.printStackTrace();
		System.exit(0);
	}

}
