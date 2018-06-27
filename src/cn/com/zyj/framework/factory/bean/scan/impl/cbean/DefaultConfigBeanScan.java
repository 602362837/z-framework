package cn.com.zyj.framework.factory.bean.scan.impl.cbean;

import java.util.Map;

import cn.com.zyj.framework.exception.RegisteredException;
import cn.com.zyj.framework.factory.bean.beans.BeanMaps;
import cn.com.zyj.framework.factory.bean.scan.impl.cbean.base.BaseConfigBeanScan;
import cn.com.zyj.framework.resources.ConfigCenter;
import cn.com.zyj.framework.utils.ClassUtil;

/**
 * 默认配置bean扫描器
 * 
 * @author mm
 *
 */
public class DefaultConfigBeanScan extends BaseConfigBeanScan {

	@Override
	public void scan() {
		if (ConfigCenter.hasSetBeans()) {
			Map<String, String> beans = ConfigCenter.getBeans();
			for (String beanId : beans.keySet()) {
				String classPath = beans.get(beanId);
				try {
					Class<?> cls = Class.forName(classPath);
					BeanMaps.registered(ClassUtil.getClassName(cls), cls);
				} catch (ClassNotFoundException e) {
					new RegisteredException("注册用户配置bean失败，beanId[" + beanId + "];beanPath[" + classPath + "]");
				}
			}
		}
	}

	@Override
	protected boolean getLockErrorOutApp() {
		return true;
	}

}
