package cn.com.zyj.framework.factory.resource;

import java.lang.reflect.Constructor;

import cn.com.zyj.framework.exception.ResourceReaderException;

/**
 * 资源阅读器建造类
 * 
 * @author Administrator
 *
 */
public final class ResourceReaderBuilder {
	/**
	 * 开始建造 (此处暂时传入什么就构造什么，之后逻辑需要修改，改为根据传入后缀选择不同类型构造器，现在是在外部固定指定)
	 * 
	 * @param readerPath
	 *            阅读器路径
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ResourceReader build(String readerPath, String configPath) {
		try {
			Class<?> readerClass = Class.forName(readerPath);
			Constructor<ResourceReader> reader = (Constructor<ResourceReader>) readerClass.getConstructor(String.class);
			return reader.newInstance(configPath);
		} catch (Exception e) {
			new ResourceReaderException("无法加载阅读器：" + readerPath, e.fillInStackTrace());
		}
		return null;
	}
}
