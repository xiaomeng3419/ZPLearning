package com.example.zpproxy;

public class YLMath implements IMath{

	@Override
	public Integer zpAdd(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("add");
		return a+b;
	}

	@Override
	public Integer zpSub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("sub");
		return a-b;
	}

}
