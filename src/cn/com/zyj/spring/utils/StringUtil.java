package cn.com.zyj.spring.utils;

public class StringUtil {

	/**
	 * 判断字符串是否不是空
	 * 
	 * @param validMsg
	 *            验证字符串
	 * @return true：非空 false：空 if validMsg==null return false if validMsg=="  "
	 *         return false if validMsg=="" return false if validMsg=="as"/"as "
	 *         return true
	 */
	public static boolean notBack(String validMsg) {
		if (validMsg == null)
			return false;
		else if ("".equals(validMsg.trim()))
			return false;
		else
			return true;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param validMsg
	 *            验证字符串
	 * @return true：非空 false：空 
	 * if validMsg==null return true 
	 * if validMsg=="  " return true 
	 * if validMsg=="" return true 
	 * if validMsg=="as"/"as " return false
	 */
	public static boolean back(String validMsg) {
		return !notBack(validMsg);
	}
}
