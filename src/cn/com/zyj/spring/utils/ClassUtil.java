package cn.com.zyj.spring.utils;

/**
 * 类操作工具
 * 
 * @author mm
 *
 */
public final class ClassUtil {

	/**
	 * 获取class名称
	 * 
	 * @param cls
	 * @return
	 */
	public static String getClassName(@SuppressWarnings("rawtypes") Class cls) {
		if (cls != null && cls.getName().contains("."))
			return cls.getName().substring(cls.getName().lastIndexOf(".") + 1);
		else
			throw new RuntimeException("");
	}
}
