package com.example.custom;

public class AllSort {
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}
	
	public static void println(int[] arr){
		for(int e : arr){
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	public static void allSort(int[] arr,int start,int end){
		if(start == end){
			println(arr);
		}
		for(int i = start;i<=end;i++){
			swap(arr,start,i);
			allSort(arr,start+1,end);
			swap(arr,start,i);
		}
		
	}
	
    public static void main(String[] args){
		int[] arr = new int[]{1,2,3,4};
		allSort(arr,0,3);		
	}

}
