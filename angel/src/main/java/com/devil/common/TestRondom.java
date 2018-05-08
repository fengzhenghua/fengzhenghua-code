package com.devil.common;

import java.util.Random;

public class TestRondom {
	
	public static int[] arr = {1,2,3,4,5,6,7,8};
	public static Random random = new Random();
	
	public static int[] getSortArr(){//数组随机排序，Random生成一个随机数，arr[random.nextInt(i+1)]-->数组中的随机数与arr[i]进行调换
		for(int i=0;i<arr.length;i++){
			int k = random.nextInt(i+1);
			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	public static void main(String[] args) {
		getSortArr();
		for(int j=0;j<8;j++){
			System.out.print(" "+arr[j]);
		}
	}
}
