package com.example.sort;
//在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
//然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
//依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。

public class UpdatedSelectSort {
	static final int SIZE=10;
	public static void select(int[]arr){	
		// 参数合法性检查
		if (arr == null || arr.length <= 1) {
			return;
		}
		int minIndex,temp,maxIndex;					//minIndex为最小值索引，temp为交换值的中间值,maxIndex为最大值的索引
		//这个算法！！！！只需跑n/2次！！！！
		for(int i=0;i<(arr.length)/2;i++){
			minIndex=i;						//先将当前变量的下标“假定义”为最小值索引
            maxIndex =i;					 //先将max和min都指向待排序的第一个元素

			for(int j=i;j<(arr.length) - i;j++){	//arr.lengh-i意义是：每次找完一个最小或者最大后，都会固定了最左边或者最右边的位置，此位置不用再遍历了的！！因为已经确定了最大或最小!!!
				if(arr[j]<arr[minIndex]){			//遍历循环的时候查找比那个最小值索引所代表变量还要小的值
					minIndex=j;						//如果找到就将它赋值给minIndex
					continue;				//找到了就终止本次循环。因为什么呢？？因为我们是以最外层的循环为根本来循环的，先以最左边的开始循环，找到最小的就固定在了最左边，第二轮就是最左边往右靠一位的位置开始循环的，再次把最大标记跟最小标记指向第二个位置！！！
				}
				if(arr[j]>arr[maxIndex]){			//这里是每次遍历选出最大的值跟最后的下标数据进行交换，然后就确定了最大值在最右边。然后第二轮从最右边往左边靠一位的那堆数据开始进行遍历查找最大值，然后放到最右边往左边靠一位的位置。
					maxIndex=j;
				}
			}
			//每次寻找最大以及最小出来，分别放在剩余位置的最左以及最右边
			//这个时候将最小值放在第i处
	        // 将最大值放在第n-i-1处
	        int maxtmp = 0;
	        int mintmp = 0;     //注意:这里不能把a[maxIndex],a[minIndex]直接和a[i]和a[n-i-1]调换。因为！！！你直接交换的话就意味着把原来a[maxIndex]和a[minIndex]给忽略了，不要这两个值了。
	        maxtmp = arr[maxIndex];	//max的交换
	        mintmp = arr[minIndex];//min的交换
	        arr[minIndex] = arr[i];//min的交换
	        arr[maxIndex] = arr[arr.length-i-1];//max的交换
	        arr[i] = mintmp;//min的交换
	        arr[arr.length-i-1] = maxtmp;//max的交换
	        
	        
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
