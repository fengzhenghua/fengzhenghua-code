package com.hera.thingking;

import java.util.Arrays;
import java.util.EmptyStackException;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年11月26日 下午10:50:49
 *@ClassName Stack
 *@Describtion
 */
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITAL_CAPACITY = 16;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e; 
	}
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		E e = elements[--size]; //获取弹出来的最后一个对象
		elements[size] = null;  //对弹出来的最后一个对象进行清空
		return e; 
	}
	public void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size+1);
		}
	}
	
	public E[] getElements() {
		return elements;
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("num1");
		stack.push("num2");
		stack.push("num3");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(getElements()[0]);
	}
	

	
}
