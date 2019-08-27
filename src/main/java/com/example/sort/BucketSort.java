package com.example.sort;

/*
 * 弊端：如果我们的数字波动范围非常大，比如1到10000，那么我们需要一个10000元素数组的空间开销，
 * 而且在倒出数字的时候需要遍历10000个桶，这样效率是非常低的，于是我们有了基于桶式排序的基数排序
 */
public class BucketSort {

	public static void main(String[] args){
		int[] a = {2,4,15,11,6,3,7,19,8,5,4};
		sort(a,19);
	}

	//桶式排序函数
	//a是要排序的数组
	//max是最大数字（这里我们默认数字最小为0）
	public static void sort(int[] a,int max){
		//声明一个数组，这就是桶，编号从0到max的桶，一共max+1个
		int[] count = new int[max + 1];
		//遍历数组，用桶计数
		for(int i = 0;i < a.length;i++){
			count[a[i]]++;
		}
		//将桶里面的数字倒出
		for(int i = max;i > 0;i--){
			while(count[i] > 0){
				System.out.print(i + " ");
				count[i]--;
			}
		}
	}

}
