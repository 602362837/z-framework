package cn.com.zyj.spring.factory.bean.scan.impl.bean.base;

import cn.com.zyj.spring.exception.BeanScanException;
import cn.com.zyj.spring.factory.bean.scan.BeanScan;
import cn.com.zyj.spring.resources.ConfigCenter;
import cn.com.zyj.spring.resources.LockCenter;

/**
 * 扫包虚类
 * 
 * @author mm
 *
 */
public abstract class BaseBeanScan implements BeanScan {
	/**
	 * 扫包根目录
	 */
	private final String rootPath;
	{
		rootPath = ConfigCenter.getRootScan();
	}

	@Override
	public void doWork() {
		if (LockCenter.tryLockBeanScan())
			scan();
		else
			getLockErrorDo();
	}

	/**
	 * 扫描器获取锁失败是否退出应用
	 * 
	 * @return
	 */
	protected abstract boolean getLockErrorOutApp();

	/**
	 * 抢锁失败异常处理方式
	 */
	private void getLockErrorDo() {
		try {
			throw new BeanScanException("类扫描器抢锁失败");
		} catch (Exception e) {
			e.printStackTrace();
			if (getLockErrorOutApp())
				System.exit(0);
		}
	}

	/**
	 * 获取扫包根路径
	 * 
	 * @return
	 */
	protected final String getRootPath() {
		return rootPath;
	}
}
