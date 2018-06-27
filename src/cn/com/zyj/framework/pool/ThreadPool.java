package cn.com.zyj.framework.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 工作线程线程池 重写是为了加入阻塞队列
 * 
 * @author ad
 *
 */
public final class ThreadPool extends ThreadPoolExecutor {
	public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	/**
	 * 工作线程每结束一个线程要来删除一个阻塞队列中的数据
	 */
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		ThreadHelper.jobQueue.poll();
	}
}
