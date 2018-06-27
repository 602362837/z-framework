package cn.com.zyj.framework.factory.bean.scan.impl.cbean.base;

import cn.com.zyj.framework.exception.ConfigBeanScanException;
import cn.com.zyj.framework.factory.bean.scan.ConfigBeanScan;
import cn.com.zyj.framework.resources.LockCenter;

/**
 * 装载配置的bean虚类
 * 
 * @author mm
 *
 */
public abstract class BaseConfigBeanScan implements ConfigBeanScan {

	@Override
	public void doWork() {
		if (LockCenter.tryLockConfigBeanScan())
			scan();
		else
			getLockErrorDo();
	}

	/**
	 * 抢锁失败异常处理方式
	 */
	private void getLockErrorDo() {
		try {
			throw new ConfigBeanScanException("配置bean扫描器抢锁失败");
		} catch (Exception e) {
			e.printStackTrace();
			if (getLockErrorOutApp())
				System.exit(0);
		}
	}

	/**
	 * 抢锁失败是否退出应用
	 * 
	 * @return
	 */
	protected abstract boolean getLockErrorOutApp();

}
