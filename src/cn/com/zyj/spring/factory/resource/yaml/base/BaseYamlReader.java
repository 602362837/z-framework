package cn.com.zyj.spring.factory.resource.yaml.base;

import java.util.concurrent.ConcurrentHashMap;

import cn.com.zyj.spring.factory.resource.ResourceReader;

/**
 * yaml配置阅读器虚类
 * 
 * @author Administrator
 *
 */
public abstract class BaseYamlReader implements ResourceReader {

	@Override
	public String readScanPackage() {
		return ResourceReader.Config.getScanPackage();
	}

	@Override
	public ConcurrentHashMap<String, String> readBeans() {
		return ResourceReader.Config.getBeans();
	}

	@Override
	public String readConfigBeanScanImpl() {
		return ResourceReader.Config.getConfigBeanScanImpl();
	}

	@Override
	public String readBeanScanImpl() {
		return ResourceReader.Config.getBeanScanImpl();
	}

	@Override
	public String readLoadScanImpl() {
		return ResourceReader.Config.getLoadScanImpl();
	}
}