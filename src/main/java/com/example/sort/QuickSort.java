package com.example.sort;

//基本思路：记录的比较和移动是从两点向中间进行的，关键码较大的记录一次就能从前面移动到后面，
//		   关键码较小的记录一次就能从后面移动到前面，记录移动的距离较远。从而减少总的比较次数和移动次数。
//		以下是一个具体例子： 保存于数据结构与算法文件夹中


//以下做法是：选择第一个记录的关键码作为轴值
public class QuickSort {

	static final int SIZE=18;
	/**		用递归进行排序
	 * 
	 * @param arr		这个传入的是待排序数组
	 * @param first		这个传入的是待排序数组的起始下标
	 * @param end		这个传入的是待排序数组的结束下标
	 */
	
	public static void quickSort(int[]arr,int first,int end){
		// 参数合法性检查
		if(arr==null||arr.length<2){
			return;
		}
		if(first<0||end<0||first>arr.length||end>arr.length|| first>=end){
			return;
		}
		if(first<end){
			int pivot=partition(arr,first,end);		//进行一次划分
			quickSort(arr,first,pivot-1);				//对左侧子序列进行递归地快速排序
			quickSort(arr,pivot+1,end);				//对右侧子序列进行递归地快速排序
		}
	}
	
	/**		计算出一个基准数
	 * 
	 * @param arr		这个传入的是待排序数组或者划分或的子序列数组
	 * @param first		这个传入的是待排序数组或者划分或的子序列数组的起始下标
	 * @param end		这个传入的是待排序数组或者划分或的子序列数组的结束下标
	 * @return
	 */
	private static int partition(int[]arr,int first,int end){
		// 参数合法性检查
		if(arr==null||arr.length<2){
			return -1;
		}
		if(first<0||end<0||first>arr.length||end>arr.length|| first>end){
			return -1;
		}
		if (first == end) {
			return first;
		}
		int pivot = arr[first]; // 将待排序列的第一个元素选作枢轴
		while(first<end){
			while(first<end&&arr[end]>=pivot){		//从后面开始循环，查找比枢轴要小的值，将他放到前面.同时指向末尾的指针也不断向前移动，判断外层while条件继续循环，直至与起始指针重合，即不满足最外层while循环的条件
				end--;
			}
			arr[first]=arr[end];			
			
			while(first<end&&arr[first]<=pivot){		//从开头开始循环，查找比枢轴要大的值，将他放到后面。同时指向起始的指针也不断向后移动，判断外层while条件继续循环，直至与末尾指针重合，即不满足最外层while循环的条件
				first++;
			}
			arr[end]=arr[first];
		}
		arr[first]=pivot;			//当first和end会和，即找到本次递归的枢轴位置了
		return first;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] shuzu =new int[SIZE];
		int i;
		for(i=0;i<SIZE;i++){
			shuzu[i]=(int)(100+Math.random()*(100+1));			//初始化数组
		}
		System.out.print("排序前的数组：\n");				//输出排序前的数组
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
		
		quickSort(shuzu,0,SIZE-1);			//快速排序操作
		System.out.print("排序后的数组：\n");			//输出排序后的数组
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
	}

}
