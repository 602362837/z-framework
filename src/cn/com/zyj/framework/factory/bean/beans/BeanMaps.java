package cn.com.zyj.framework.factory.bean.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.com.zyj.framework.exception.LoadBeanException;
import cn.com.zyj.framework.exception.RegisteredException;
import cn.com.zyj.framework.utils.StringUtil;

/**
 * 托管的单例类
 * 
 * @author mm
 *
 */
public final class BeanMaps {
	/**
	 * beanNmae:Bean键值对
	 */
	private final static Map<String, Bean> nameBeanMap;
	/**
	 * baenName:Object键值对
	 */
	private final static Map<String, Object> nameObjMap;
	static {
		nameBeanMap = new ConcurrentHashMap<>();
		nameObjMap = new ConcurrentHashMap<>();
	}

	/**
	 * 注册bean信息到beanMap
	 * 
	 * @param name
	 * @param zclass
	 */
	public static void registered(String name, Class<?> cls) {
		if (StringUtil.notBack(name) && cls == null)
			throw new RegisteredException("注册bean失败，注册name为【" + name + "】");
		else if (StringUtil.back(name) && cls != null)
			throw new RegisteredException("注册bean失败，注册class为【" + cls.toString() + "】");
		else if (StringUtil.back(name) && cls == null)
			throw new RegisteredException("注册bean失败，未提供beanName与class");
		try {
			Object loadObject = cls.newInstance();
			Bean bean = new Bean(loadObject, cls);
			nameBeanMap.put(name.toLowerCase(), bean);
			nameObjMap.put(name.toLowerCase(), loadObject);
		} catch (Exception e) {
			new RegisteredException("注册bean失败");
		}
	}

	/**
	 * 获取bean
	 * 
	 * @param beanName
	 * @return
	 * @return
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <V> V getBean(String beanName) {
		@SuppressWarnings("unused")
		Map<String, Bean> map = nameBeanMap;
		String key = beanName.toLowerCase();
		try {
			return (V) nameBeanMap.get(key).getBean();
		} catch (NullPointerException e) {
			throw new LoadBeanException(beanName);
		}
	}

	/**
	 * 获取beanMap
	 * 
	 * @return
	 */
	@Deprecated
	public static Map<String, Bean> getBeanMap() {
		return nameBeanMap;
	}

	/**
	 * 获取name:objmap
	 * 
	 * @return
	 */
	public static Map<String, Object> getNameObjMap() {
		return nameObjMap;
	}

	private static final class Bean {
		/**
		 * bean实例
		 */
		private Object bean;
		/**
		 * bean的class信息
		 */
		private Class<?> cls;

		public Bean(Object bean, Class<?> cls) {
			this.bean = bean;
			this.cls = cls;
		}

		public Object getBean() {
			return bean;
		}

		@SuppressWarnings("unused")
		public Class<?> getCls() {
			return (Class<?>) cls;
		}

	}

}
