package cn.com.zyj.spring.factory.bean.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口托管注解
 * 暂时只支持类名匹配注入
 * @author mm
 *
 */
@Inherited  
@Target({ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface Exposed {
	/**
	 * 默认靠名发现
	 * 暂未实现该字段功能
	 * @return
	 */
	@Deprecated
	Type type() default Type.NAME;
	/**
	 * 注册名称
	 * 若填写则忽略type人为设置，type强制设置为name
	 * 没填写获取类名
	 * 设置的值会全转成小写
	 * @return
	 */
	String value() default "";
	public enum Type{
		/**
		 * 依靠类名完成托管
		 */
		NAME,
		/**
		 * 依靠类类型完成托管
		 */
		TYPENAME
	}
}
