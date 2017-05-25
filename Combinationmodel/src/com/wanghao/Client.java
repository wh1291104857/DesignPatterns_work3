package com.wanghao;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		boolean bo =true;
		do{
			System.out.println("输入一个整数：");
			Scanner sc=new Scanner(System.in);
			int n = sc.nextInt();
			if(n>=1){
				System.out.println(n + "的阶乘是:" + new Composite(n).factorial());
			}else{
				System.out.println("输入有误，请重新输入");
			}
			
		}while(bo);
	}
}
