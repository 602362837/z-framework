package cn.com.zyj.framework.factory.bean.scan.base;

import cn.com.zyj.framework.work.Worker;

/**
 * 所有扫描器父类
 * 
 * @author mm
 *
 */
public interface BaseScan extends Worker {
	/**
	 * 扫描方法
	 */
	public void scan();
}
