package cn.com.zyj.framework.factory.bean;

import cn.com.zyj.framework.factory.bean.beans.BeanMaps;

/**
 * bean中心
 * 
 * @author mm
 *
 */
public final class BeanCenter {
	/**
	 * 获取bean
	 * 
	 * @param beanId
	 * @return
	 */
	public static <V> V getBean(String beanId) {
		V bean = BeanMaps.getBean(beanId);
		return bean;
	}
}
