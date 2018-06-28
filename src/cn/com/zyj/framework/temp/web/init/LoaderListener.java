package cn.com.zyj.framework.temp.web.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.com.zyj.framework.init.ZApplication;

/**
 * 加载模块监听器-集成web使用 为了尽快集成web引入，下版本移除
 * 
 * @author Administrator
 *
 */
public class LoaderListener implements ServletContextListener {
	/**
	 * 应用关闭
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 应用开启
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String configPath = context.getInitParameter("z-framework-config");
		new ZApplication(configPath);
	}

}
