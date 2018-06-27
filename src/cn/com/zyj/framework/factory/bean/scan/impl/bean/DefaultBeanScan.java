package cn.com.zyj.framework.factory.bean.scan.impl.bean;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.List;

import cn.com.zyj.framework.factory.bean.annotation.Exposed;
import cn.com.zyj.framework.factory.bean.beans.BeanMaps;
import cn.com.zyj.framework.factory.bean.scan.impl.bean.base.BaseBeanScan;
import cn.com.zyj.framework.utils.ClassUtil;
import cn.com.zyj.framework.utils.StringUtil;

/**
 * 默认类扫描器
 * 
 * @author mm
 *
 */
public final class DefaultBeanScan extends BaseBeanScan {

	@Override
	public void scan() {
		String rootPath = super.getRootPath();
		if (StringUtil.back(rootPath))
			return;
		List<String> classPaths = new LinkedList<>();
		String baseClasspath = DefaultBeanScan.class.getResource("/").getPath();
		if (baseClasspath.startsWith("/"))
			baseClasspath = baseClasspath.replaceFirst("/", "");
		rootPath = rootPath.replace(".", "/");
		String path = baseClasspath + rootPath;
		iteratePath(new File(path), classPaths);
		for (String classPath : classPaths) {
			classPath = classPath.replace("\\", "/").replace(baseClasspath, "").replace("/", ".").replace(".class", "");
			Class<?> cls;
			try {
				cls = Class.forName(classPath);
				Annotation exposedClass = cls.getDeclaredAnnotation(Exposed.class);
				if (exposedClass != null)
					BeanMaps.registered(ClassUtil.getClassName(cls), cls);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	@Override
	protected boolean getLockErrorOutApp() {
		return true;
	}

	/**
	 * 遍历文件夹，向集合添加class文件路径
	 * 
	 * @param file
	 * @param classPaths
	 */
	private void iteratePath(File file, List<String> classPaths) {
		if (file.isDirectory()) {// 文件夹
			// 文件夹我们就递归
			File[] files = file.listFiles();
			for (File f1 : files) {
				iteratePath(f1, classPaths);
			}
		} else {// 标准文件
			// 标准文件我们就判断是否是class文件
			if (file.getName().endsWith(".class")) {
				// 如果是class文件我们就放入我们的集合中。
				classPaths.add(file.getPath());
			}
		}
	}

}
