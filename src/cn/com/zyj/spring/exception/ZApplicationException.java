package cn.com.zyj.spring.exception;

public class ZApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZApplicationException(String message) {
		super("ZApplication 发生严重错误,应用退出:" + message);
		super.printStackTrace();
		System.exit(0);
	}

}
