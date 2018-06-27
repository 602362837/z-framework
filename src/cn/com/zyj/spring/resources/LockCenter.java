package cn.com.zyj.spring.resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁中心
 * 
 * @author mm
 *
 */
public final class LockCenter {
	/**
	 * 类扫描器锁(建议不释放)
	 */
	private final static Lock beanScan = new ReentrantLock();
	/**
	 * 加载被托管属性锁（建议不释放）
	 */
	private final static Lock loadScan = new ReentrantLock();
	/**
	 * 配置bean锁(建议不释放)
	 */
	private final static Lock configBeanScan = new ReentrantLock();

	public static boolean tryLoadScan() {
		return LockCenter.tryLock(loadScan);
	}

	public static boolean tryLockBeanScan() {
		return LockCenter.tryLock(beanScan);
	}

	public static boolean tryLockConfigBeanScan() {
		return LockCenter.tryLock(configBeanScan);
	}

	/**
	 * 加锁
	 * 
	 * @param lock
	 */
	@SuppressWarnings("unused")
	private static void lock(Lock lock) {
		lock.lock();
	}

	/**
	 * 加锁 立刻获取结果
	 * 
	 * @param lock
	 */
	private static boolean tryLock(Lock lock) {
		return lock.tryLock();
	}

	/**
	 * 解锁
	 * 
	 * @param lock
	 */
	@SuppressWarnings("unused")
	private static void unLock(Lock lock) {
		lock.unlock();
	}

}
