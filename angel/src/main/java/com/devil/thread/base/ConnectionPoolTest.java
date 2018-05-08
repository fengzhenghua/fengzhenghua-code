package com.devil.thread.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@authur fengzhenghua 2017年9月16日 下午10:33:40
 *@ClassName ConnectionPoolTest
 *@Describtion
 */
public class ConnectionPoolTest {
	static ConnectionPool pool = new ConnectionPool(10);
	//一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
	static CountDownLatch start = new CountDownLatch(1);
	static CountDownLatch end ;
	
	public static void main(String[] args) throws Exception {
		int threadCount = 15;
		end = new CountDownLatch(threadCount);
		int count  =20;
		//可以用原子方式更新的 int 值。
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for(int i=0;i<threadCount;i++) {
			Thread thread = new Thread(new ConnectionRunner(count, got, notGot),"ConnectionRunnerThread");
			thread.start();
		}
		// 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。
		start.countDown();
		
		end.await();
		System.out.println("total invoke: " + (threadCount * count));
		System.out.println("got connection: " + got);
		System.out.println("not got connection: " + notGot);
		
	}
	
	static class ConnectionRunner implements Runnable {
		
		int count ;
		AtomicInteger got;
		AtomicInteger notGot;
		
		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			super();
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		@Override
		public void run() {
			try {
				start.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while(count > 0) {
				//从线程池中获取连接，如果1000ms内无法获取到，将会返回null
				//分别统计连接获取的数量got和未获取到的数量notGot
				try {
					Connection connection = pool.fetchConnection(1000);
					if(connection != null) {
						try {
							connection.createStatement();
							connection.commit();
						}catch(SQLException s){
							s.printStackTrace();
						}finally {
							pool.releaseConnection(connection);
							got.incrementAndGet();//自增
						}
					}else {
						notGot.incrementAndGet();//自增
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					count--;
				}
				
			}
			end.countDown();
		}
		
		
	}
}
