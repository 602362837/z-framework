package cn.com.zyj.spring.factory.bean.scan.impl.load;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

import cn.com.zyj.spring.exception.LoadBeanException;
import cn.com.zyj.spring.factory.bean.annotation.Loading;
import cn.com.zyj.spring.factory.bean.beans.BeanMaps;
import cn.com.zyj.spring.factory.bean.scan.impl.load.base.BaseLoadScan;
import cn.com.zyj.spring.utils.StringUtil;

/**
 * 默认装载器
 * 
 * @author mm
 *
 */
public final class DefaultLoadScan extends BaseLoadScan {

	private Map<String, Object> nameObjMap = BeanMaps.getNameObjMap();

	@Override
	public void scan() {
		if (nameObjMap == null || nameObjMap.size() <= 0)
			return;
		for (String key : nameObjMap.keySet()) {
			Object obj = nameObjMap.get(key);
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				Annotation[] fieldAnnotation = field.getAnnotations();
				for (Annotation annotation : fieldAnnotation) {
					if (annotation.annotationType() == Loading.class) {
						Loading loadAnnotation = (Loading) annotation;
						loadField(field, obj, loadAnnotation.value());
					}
				}
			}
		}

	}

	@Override
	protected boolean getLockErrorOutApp() {
		return true;
	}

	private void loadField(Field field, Object obj, String beanName) {
		if (field == null)
			return;
		try {
			if (StringUtil.back(beanName))
				beanName = field.getName();
			field.setAccessible(true);
			field.set(obj, nameObjMap.get(beanName.toLowerCase()));
		} catch (Exception e) {
			throw new LoadBeanException(beanName, field.getType().getName());
		}
	}

}
