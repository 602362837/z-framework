package cn.com.zyj.framework.exception;

public class ReadYamlConfigException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ReadYamlConfigException(String message) {
		super("读取yaml配置文件错误：" + message);
	}

}
