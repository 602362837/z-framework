package cn.com.zyj.spring.resources;

import java.util.Map;

import cn.com.zyj.spring.factory.resource.ResourceReader;
import cn.com.zyj.spring.factory.resource.ResourceReaderBuilder;
import cn.com.zyj.spring.init.ZApplication;
import cn.com.zyj.spring.utils.StringUtil;

/**
 * 配置中心
 * 
 * @author mm
 *
 */
public final class ConfigCenter {
	// 默认文件阅读器(之后需要根据实例信息选择，暂时此处写死)
	private final static String defaultResourceReader;
	private final static ResourceReader resourceReader;
	// 默认配置bean扫描器路径
	private final static String defaulConfigBeanScanImpl;
	// 默认bean扫描器路径
	private final static String defaultBeanScanImpl;
	// 默认加载器路径
	private final static String defaultLoadScanImpl;
	static {
		defaultResourceReader = StaticVariable.defaultResourceReaderPath;
		defaulConfigBeanScanImpl = StaticVariable.defaultConfigBeanScanPath;
		defaultBeanScanImpl = StaticVariable.defaultBeanScanPath;
		defaultLoadScanImpl = StaticVariable.defaultLoadScanPath;
		resourceReader = ResourceReaderBuilder.build(defaultResourceReader,ZApplication.getResourcePath());
	}

	/**
	 * 获取扫描包根路径 null/"":不使用扫包方式 (如果没填写退出应用)
	 * 
	 * @return
	 */
	public static String getRootScan() {
		String rootScan = resourceReader.readScanPackage();
		if (StringUtil.back(rootScan))
			System.exit(0);
		return rootScan;
	}

	/**
	 * 获取配置bean扫描器路径
	 * 
	 * @return
	 */
	public static String getConfigBeanScan() {
		String userSetConfigBeanScanImpl = resourceReader.readConfigBeanScanImpl();
		return StringUtil.notBack(userSetConfigBeanScanImpl) ? userSetConfigBeanScanImpl : defaulConfigBeanScanImpl;
	}

	/**
	 * 获取扫描器路径
	 * 
	 * @return
	 */
	public static String getBeanScan() {
		String userSetBeanScanImpl = resourceReader.readBeanScanImpl();
		return StringUtil.notBack(userSetBeanScanImpl) ? userSetBeanScanImpl : defaultBeanScanImpl;
	}

	/**
	 * 获取加载器路径
	 * 
	 * @return
	 */
	public static String getLoadScan() {
		String userSetLoadScanImpl = resourceReader.readLoadScanImpl();
		return StringUtil.notBack(userSetLoadScanImpl) ? userSetLoadScanImpl : defaultLoadScanImpl;
	}

	/**
	 * 获取用户配置的beans
	 * 
	 * @return
	 */
	public static Map<String, String> getBeans() {
		return resourceReader.readBeans();
	}

}
