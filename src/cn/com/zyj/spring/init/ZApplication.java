package cn.com.zyj.spring.init;

import cn.com.zyj.spring.exception.ZApplicationException;
import cn.com.zyj.spring.factory.bean.BeanCenter;
import cn.com.zyj.spring.factory.bean.scan.BeanScan;
import cn.com.zyj.spring.factory.bean.scan.ConfigBeanScan;
import cn.com.zyj.spring.factory.bean.scan.LoadScan;
import cn.com.zyj.spring.factory.resource.ResourceReaderBuilder;
import cn.com.zyj.spring.resources.ConfigCenter;
import cn.com.zyj.spring.resources.StaticVariable;
import cn.com.zyj.spring.work.WorkHelper;

/**
 * 加载应用
 * 
 * @author mm
 *
 */
public final class ZApplication {
	/**
	 * 应用是否加载过标识
	 */
	private static boolean useFlag = false;
	/**
	 * 资源加载器路径
	 */
	private static String resourcePath;
	

	/**
	 * 配置bean扫描器
	 */
	private ConfigBeanScan configBeanScanServer;
	/**
	 * bean扫描器
	 */
	private BeanScan beanScanServer;
	/**
	 * 装载扫描器
	 */
	private LoadScan loadScanServer;
	// {
	// injectedConfigBeanScan();
	// injectedBeanScan();
	// injectedLoadScan();
	// }

	public ZApplication(String resourcePath) {
		if (!useFlag)
			init(resourcePath);
		else
			new ZApplicationException("ZApplication同一应用中只能加载一次");
	}

	/**
	 * 加载应用 （之后此处文件阅读器路径需要修改）
	 */
	private void init(String resourcePath) {
		ZApplication.resourcePath = resourcePath;
		buildWorkers();
		WorkHelper.doWorks(false, configBeanScanServer, beanScanServer, loadScanServer);
		useFlag = true;
	}

	/**
	 * 构造工作者
	 */
	private void buildWorkers() {
		injectedConfigBeanScan();
		injectedBeanScan();
		injectedLoadScan();
	}

	/**
	 * 注入装载扫描器
	 */
	private void injectedLoadScan() {
		String scanPath = ConfigCenter.getLoadScan();
		try {
			Class<?> scanClass = Class.forName(scanPath);
			loadScanServer = (LoadScan) scanClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * 注入配置bean扫描器
	 */
	private void injectedConfigBeanScan() {
		String scanPath = ConfigCenter.getConfigBeanScan();
		try {
			Class<?> scanClass = Class.forName(scanPath);
			configBeanScanServer = (ConfigBeanScan) scanClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * 注入bean扫描器
	 */
	private void injectedBeanScan() {
		String scanPath = ConfigCenter.getBeanScan();
		try {
			Class<?> scanClass = Class.forName(scanPath);
			beanScanServer = (BeanScan) scanClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * 从bean中心获取bean
	 * 
	 * @param beanId
	 * @return
	 */
	public static <V> V getBean(String beanId) {
		return BeanCenter.getBean(beanId);
	}
	/**
	 * 提供外部使用配置文件路径
	 * @return
	 */
	public static String getResourcePath(){
		return resourcePath;
	}
}
