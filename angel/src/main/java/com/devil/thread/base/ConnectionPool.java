package com.devil.thread.base;

import java.sql.Connection;
import java.util.LinkedList;

/**
 *@authur fengzhenghua 2017年9月16日 下午8:08:19
 *@ClassName ConnectionPool
 *@Describtion
 */
public class ConnectionPool {
	
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	
	public ConnectionPool(int initialSize) {
		if(initialSize > 0) {
			for(int i=0;i < initialSize ; i++) {
				pool.addLast(ConnectionDriver.createConnection());//往后添加元素，返回最后一个代理Connection对象
			}
		}
	}
	
	//释放资源
	public void releaseConnection(Connection connection	) {
		if(connection != null) {
			synchronized (pool) {
				//连接释放后需要进行通知，这样其他消费者能够感知到连接池中已归还了一个连接
				pool.addLast(connection);
				pool.notifyAll();
			}
		}
	}
	
	//在mills内无法获得连接，将会返回null
	public Connection fetchConnection(long mills) throws InterruptedException {
		synchronized (pool) {
			if(mills <= 0) {
				while(pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			}else {
				long future = System.currentTimeMillis() + mills;//超时时间
				long remaining = mills;//等待持续时间
				while(pool.isEmpty() && remaining>0) {
					pool.wait(remaining);
					remaining = future - System.currentTimeMillis();//还需等待时间
				}
				Connection  resurt = null;
				if(!pool.isEmpty()) {
					resurt = pool.removeFirst();
				}
				return resurt;
			}
			
		}
	}
}
