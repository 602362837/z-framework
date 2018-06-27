package cn.com.zyj.spring.work;

import java.util.Collection;

import cn.com.zyj.spring.pool.ThreadHelper;

/**
 * 工作者帮助方法
 * 
 * @author Administrator
 *
 */
public class WorkHelper {
	/**
	 * 驱动工作者进行工作
	 * 
	 * @param sync
	 *            是否同步进行
	 * @param workers
	 *            工作者
	 */
	public static void doWorks(boolean sync, Worker... workers) {
		for (Worker worker : workers) {
			doWork(sync, worker);
		}
	}

	/**
	 * 驱动工作者进行工作
	 * 
	 * @param sync
	 *            是否同步进行
	 * @param workers
	 *            工作者
	 */
	public static void doWorks(boolean sync, Collection<Worker> workers) {
		for (Worker worker : workers) {
			doWork(sync, worker);
		}
	}

	/**
	 * 驱动工作者进行工作
	 * 
	 * @param sync
	 * @param worker
	 */
	private static void doWork(boolean sync, Worker worker) {
		if (worker == null)
			return;
		if (sync) {
			Thread job = new Thread() {
				@Override
				public void run() {
					worker.doWork();
				}
			};
			ThreadHelper.executionJob(job);
		} else {
			worker.doWork();
		}
	}
}
