package com.example.sort;
//在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
//好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
//也是排好顺序的。如此反复循环，直到全部排好顺序。
//最坏情况：比较(n+2)(n-1)/2次，移动(n+4)(n-1)/2次

//这个算法是使用数组的0号单元作暂存单元和监视哨兵。即：这个的插入只可以排数组的n-1个（n为数组长度）。
public class InsertSort {

	static final int SIZE=100;
	
	static void insertionSort(int[]a){
		// 合法性检查
		if (a== null || a.length < 2) {//0号位是暂存单位，所以只有1号存了一个数据的话就不用排序啦。
			return;
		}
		int i,j;				//i为无序区循环变量
		for(i=2;i<=a.length-1;i++){//插入第i个记录,遍历无序区			//遍历n-1次为什么？？因为我们做的是插入动作，这里第一轮就是把第三个元素赋值给0号单元，拿0号单元的跟后面的元素去对比插入。如果小于1号位元素则1号位往后移，2号位的放在第一位。如果不小于就保留原来位置，到外层循环遍历无序区往后遍历
			a[0]=a[i];		//设置哨兵，0号存储单元就是
			for(j=i-1;j>0&&a[0]<a[j];j--){
				a[j+1]=a[j];				//遍历有序区，如果利用0号暂存单元找到在有序区比它大的数据，就插入他前面（就是他以及他后面的数据往后移）
			}
			//退出循环，说明找到了插入位置，因为a[j]刚比较完毕，所以j+1是争取的插入位置，将待插入记录插进去
            //如果不小于就保留原来位置，到外层循环遍历无序区往后遍历。如果小于，这里是利用0号单元赋值到有序区，赋值到一号元素前面。
			a[j+1]=a[0];
			System.out.print("第"+(i-1)+"步排序结果");				//输出每一步排序的结果
			for(int z=0;z<a.length;z++){
				System.out.print(" "+a[z]);
			}
			System.out.print("\n");
		}
	}

	/**
     * 100个随机数
     * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] shuzu =new int[SIZE];
		int i;
		for(i=1;i<SIZE;i++){
			shuzu[i]=(int)(100+Math.random()*(100+1));			//初始化数组。只给了9个数据，因为数组中的0号位是作为暂存的。
		}
		System.out.print("排序前的数组：\n");				//输出排序前的数组
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i]+" ");
		}
        long begin= System.currentTimeMillis();
		System.out.print("\n sys cur time:"+begin+"\n");

		insertionSort(shuzu);			//插入排序操作
        long end= System.currentTimeMillis();
        System.out.print("use time:"+(end-begin)+"\n");
        System.out.print("排序后的数组：\n");			//输出排序后的数组
		for(i=0;i<SIZE;i++){
			System.out.print(shuzu[i]+" ");
		}
		System.out.print("\n");
	}

}
