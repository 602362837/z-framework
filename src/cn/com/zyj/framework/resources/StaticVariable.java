package cn.com.zyj.framework.resources;

/**
 * 静态资源信息
 * 
 * @author mm
 *
 */
public final class StaticVariable {
	/**
	 * 默认文件阅读器路径
	 */
	public final static String defaultResourceReaderPath = "cn.com.zyj.framework.factory.resource.DefaultYamlReader";
	/**
	 * 默认配置bean扫描器路径
	 */
	public final static String defaultConfigBeanScanPath = "cn.com.zyj.framework.factory.bean.scan.impl.cbean.DefaultConfigBeanScan";
	/**
	 * 默认bean扫描器路径
	 */
	public final static String defaultBeanScanPath = "cn.com.zyj.framework.factory.bean.scan.impl.bean.DefaultBeanScan";
	/**
	 * 默认装载扫描器路径
	 */
	public final static String defaultLoadScanPath = "cn.com.zyj.framework.factory.bean.scan.impl.load.DefaultLoadScan";

}
