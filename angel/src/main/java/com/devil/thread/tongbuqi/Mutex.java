package com.devil.thread.tongbuqi;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 *@authur fengzhenghua 2017年10月17日 下午10:45:27
 *@ClassName Mutex
 *@Describtion
 */
public class Mutex {
	
	//静态内部类，自定义同步器
	private static class Sync extends AbstractQueuedSynchronizer{
		//是否处于占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
		//当状态等于0时获取锁
		public boolean tryAcquire(int acquires) {
			if(compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		//释放锁，将状态设置为0
		protected boolean tryRelease(int releases) {
			if(getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		//返回一个Condition,每个condition都包含一个condition队列
		Condition newCondition() {return new ConditionObject();}
	}
	//将操作代理到Sync上即可
	private final Sync sync = new Sync();
	
	 //获取等待的线程  
    public Collection<Thread> getQueuedThreads(){  
        return sync.getQueuedThreads();  
    }
    //独占锁的操作接口
	public void lock() {
		sync.acquire(1);
	}
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}
	public void unlock() {
		sync.release(1);
	}
	public Condition newCondition(){
		return sync.newCondition();
	}
	public boolean isLocked() {
		return sync.isHeldExclusively();
	}
	public boolean hasQueueThreads() {
		return sync.hasQueuedThreads();
	}
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}
	public boolean tryLock(long timeout,TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}
}
