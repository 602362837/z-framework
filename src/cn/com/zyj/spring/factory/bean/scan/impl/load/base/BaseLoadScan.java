package cn.com.zyj.spring.factory.bean.scan.impl.load.base;

import cn.com.zyj.spring.exception.BeanScanException;
import cn.com.zyj.spring.factory.bean.scan.LoadScan;
import cn.com.zyj.spring.resources.LockCenter;

/**
 * 加载被託管属性虚类
 * 
 * @author mm
 *
 */
public abstract class BaseLoadScan implements LoadScan {
	@Override
	public final void doWork() {
		if (LockCenter.tryLoadScan())
			scan();
		else
			getLockErrorDo();
	}

	/**
	 * 抢锁失败后是否退出应用
	 * 
	 * @return
	 */
	protected abstract boolean getLockErrorOutApp();

	/**
	 * 抢锁失败处理
	 */
	private void getLockErrorDo() {
		try {
			throw new BeanScanException("装载器抢锁失败");
		} catch (Exception e) {
			e.printStackTrace();
			if (getLockErrorOutApp())
				System.exit(0);
		}
	}
}
