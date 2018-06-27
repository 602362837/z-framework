package cn.com.zyj.spring.factory.resource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.com.zyj.spring.exception.ReadYamlConfigException;

/**
 * 资源阅读器
 * 
 * @author Administrator
 *
 */
public interface ResourceReader {
	/**
	 * 获取扫包根路径
	 * 
	 * @return
	 */
	public String readScanPackage();

	/**
	 * 获取用户手工配置的bean信息
	 * 
	 * @return
	 */
	public ConcurrentHashMap<String, String> readBeans();

	/**
	 * 获取用户自定义的配置bean扫描器
	 * 
	 * @return
	 */
	public String readConfigBeanScanImpl();

	/**
	 * 获取用户自定义的bean扫描器
	 * 
	 * @return
	 */
	public String readBeanScanImpl();

	/**
	 * 获取用户自定义的加载器
	 * 
	 * @return
	 */
	public String readLoadScanImpl();

	public final static class Config {
		/**
		 * 设置属性值
		 * 
		 * @param configMap
		 */
		@SuppressWarnings("unchecked")
		protected static void setConfig(Map<String, Object> configMap) {
			if (configMap != null && configMap.size() > 0) {
				for (String key : configMap.keySet()) {
					Object value = configMap.get(key);
					if ("scanPackage".equals(key))
						scanPackage = (String) value;
					else if ("configBeanScanImpl".equals(key))
						configBeanScanImpl = (String) value;
					else if ("beanScanImpl".equals(key))
						beanScanImpl = (String) value;
					else if ("loadScanImpl".equals(key))
						loadScanImpl = (String) value;
					else if ("beans".equals(key))
						beans = new ConcurrentHashMap<String, String>((Map<String, String>) value);
					else
						new ReadYamlConfigException("未定义该类型配置【" + key + "】").printStackTrace();
				}
			}
		}

		/**
		 * 扫描托管bean包路径
		 */
		private static String scanPackage;
		/**
		 * 人工配置bean列表
		 */
		private static ConcurrentHashMap<String, String> beans;
		/**
		 * 配置bean扫描器实现类
		 */
		private static String configBeanScanImpl;
		/**
		 * bean扫描器实现类
		 */
		private static String beanScanImpl;
		/**
		 * bean加载器实现类
		 */
		private static String loadScanImpl;

		public static String getScanPackage() {
			return scanPackage;
		}

		public static ConcurrentHashMap<String, String> getBeans() {
			return beans;
		}

		public static String getConfigBeanScanImpl() {
			return configBeanScanImpl;
		}

		public static String getBeanScanImpl() {
			return beanScanImpl;
		}

		public static String getLoadScanImpl() {
			return loadScanImpl;
		}
	}
}
