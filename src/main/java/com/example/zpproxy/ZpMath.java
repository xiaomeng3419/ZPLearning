package com.example.zpproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ZpMath implements IMath {
	IMath meta = new YLMath();

//	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public Integer zpAdd(int a, int b) {
		
		// TODO Auto-generated method stub
		System.out.println("start time: "+sdf.format(new Date()));
		System.out.println("result value: "+ meta.zpAdd(a, b));
		System.out.println("end time: "+sdf.format(new Date()));
		return meta.zpAdd(a, b);
	}

	@Override
	public Integer zpSub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("start time: "+sdf.format(new Date()));
		System.out.println("result value: "+ meta.zpSub(a, b));
		System.out.println("end time: "+sdf.format(new Date()));
		return meta.zpSub(a, b);
	}

}
