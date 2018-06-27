package cn.com.zyj.spring.factory.bean.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 加载托管的类(暂时只支持name)
 * @author mm
 *
 */
@Inherited  
@Target({ElementType.FIELD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented 
public @interface Loading {
	/**
	 * 被暴露类的名称/类型名
	 * 暂时只提供了类名匹配注入
	 * @return
	 */
	String value() default "";
}
