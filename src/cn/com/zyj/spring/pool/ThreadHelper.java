package cn.com.zyj.spring.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import cn.com.zyj.spring.exception.ThreadHelperException;

/**
 * 线程操作帮助类
 * 
 * @author Administrator
 *
 */
public class ThreadHelper {
	// 线程池使用的阻塞队列
	protected static BlockingQueue<Runnable> jobQueue = new LinkedBlockingQueue<Runnable>(10);
	// 线程池
	private static ExecutorService jobPool = new ThreadPool(5, 10, 10, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>());

	/**
	 * 执行线程
	 * 
	 * @param job
	 */
	public static void executionJob(Thread job) {
		try {
			jobQueue.put(job);
			jobPool.execute(job);
		} catch (Exception e) {
			new ThreadHelperException(e.getMessage()).printStackTrace();
		}
	}
}
