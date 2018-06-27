package cn.com.zyj.spring.factory.bean.scan.impl.cbean;

import java.util.Map;

import cn.com.zyj.spring.exception.RegisteredException;
import cn.com.zyj.spring.factory.bean.beans.BeanMaps;
import cn.com.zyj.spring.factory.bean.scan.impl.cbean.base.BaseConfigBeanScan;
import cn.com.zyj.spring.resources.ConfigCenter;
import cn.com.zyj.spring.utils.ClassUtil;

/**
 * 默认配置bean扫描器
 * 
 * @author mm
 *
 */
public class DefaultConfigBeanScan extends BaseConfigBeanScan {

	@Override
	public void scan() {
		// if(ConfigYamlHelper.Config.hasBeans()){
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
		// }
	}

	@Override
	protected boolean getLockErrorOutApp() {
		return true;
	}

}
