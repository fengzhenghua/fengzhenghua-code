package com.hera.thingking.genericity;

/**
 *@authur fengzhenghua 2018年1月22日 上午12:00:25
 *@ClassName LinkedList
 *@Describtion 不用LinkedList用自己内部链式存储机制实现一个堆栈类
 */
public class LinkedStack<T> {
	private static class Node<U> {
		U item;
		Node<U> next;//下一个Node对象
		Node(){
			item = null; next = null;
		}
		
		Node(U item, Node<U> next){
			this.item = item;
			this.next = next;
		}
		
		boolean end() {
			return item == null && next == null;
		}
	}
	
	private Node<T> top = new Node<T>();
	public void push(T item) {
		top = new Node<T>(item, top);//把新的top对象放入top中
	}
	
	public T pop() { //弹出一个Node的item对象
		T result = top.item;
		if(!top.end()) {
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<>();
		for(String s : "I am a god".split(" ")) {
			lss.push(s);
		}
		String s;
		while((s = lss.pop()) != null) {
			System.out.print(s + " ");
		}
	}
}
