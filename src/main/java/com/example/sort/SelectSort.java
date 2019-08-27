package com.example.sort;
//简单选择排序(单向选择排序):此处定为-从小到大排序
//从所有序列中先找到最小的，然后放到第一个位置。之后再看剩余元素中最小的，放到第二个位置⋯⋯以此类推，就可以完成整个的排序工作了。
//可以很清楚的发现，选择排序是固定位置，找元素。相比于插入排序的固定元素找位置，是两种思维方式。

//，寻找最小的元素需要一个循环的过程，而排序又是需要一个循环的过程。因此显而易见，这个算法的时间复杂度也是O(n*n)的。
//这就意味值在n比较小的情况下，算法可以保证一定的速度，当n足够大时，算法的效率会降低。并且随着n的增大，算法的时间增长很快。
public class SelectSort {
	static final int SIZE=10;
	public static void select(int[]arr){	
		// 参数合法性检查
		if (arr == null || arr.length <= 1) {
			return;
		}
		int minIndex,temp;					//minIndex为最小值索引，temp为交换值的中间值
		//!!!!!!!这个算法要跑n次！！！！
		for(int i=0;i<arr.length;i++){
			minIndex=i;						//先将当前变量的下标“假定义”为最小值索引
	
			//这里是每次遍历选出最小的值跟最前的下标数据进行交换，然后就确定了最小值在最左边。
			//然后第二轮从最左边往右边靠一位的那堆数据开始进行遍历查找最小值，然后放到最左边往右边靠一位的位置。
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){			//遍历循环的时候查找比那个最小值索引所代表变量还要小的值
					minIndex=j;						//如果找到就将它赋值给minIndex
				}
			}
			//交换两个数
			if(minIndex!=i){
				temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
			System.out.print("第"+i+"步排序结果");				//输出每一步排序的结果
			for(int h=0;h<arr.length;h++){
				System.out.print(" "+arr[h]);
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[]args){
		 int[]shuzu=new int[SIZE];
		 int i;
		 for(i=0;i<SIZE;i++){
			 shuzu[i]=(int)(100+Math.random()*(100+1));			//初始化数组
		 }
		 System.out.print("排序前的数组为：\n");				//输出排序前的数组
		 for(i=0;i<SIZE;i++){
			System.out.print(" "+shuzu[i]);
		 }
		 System.out.print("\n");
		 
		 select(shuzu);								//执行排序算法
		 System.out.print("输出排序后的数组为：\n");
		 for(i=0;i<SIZE;i++){
				System.out.print(" "+shuzu[i]);
		 }
		 System.out.print("\n");
	}
}
