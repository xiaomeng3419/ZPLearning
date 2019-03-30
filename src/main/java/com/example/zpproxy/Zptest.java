package com.example.zpproxy;

import java.math.MathContext;

public class Zptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ZpMath zp = new ZpMath();
//		zp.zpAdd(250, 270);
//		zp.zpSub(111, 23);
		
		
//		IMath math = (IMath) new ZPDynamicProxy().getProxyObject(new ZpMath());
		YLMath math = (YLMath) new DynamicProxy().getProxyObject(new YLMath());
		int n1=100,n2=5;
        math.zpAdd(n1, n2);
        math.zpSub(n1, n2);
	}

}
