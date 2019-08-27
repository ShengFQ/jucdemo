package com.example.sort;

//希尔排序，相对直接插入排序有较大的改进。希尔排序又叫缩小增量排序
//基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
/* 算法核心.
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有序的情况下（接近最好情况），
 * 效率是很高的，
*/
//第一种和第二种只是不同的直接插入写法，本质一样
public class ShellSort {

	static final int SIZE = 10;

	static void shellSort(int[] a) {
		// 合法性检查
		if (a == null || a.length < 2) {
			return;
		}
		int i, j; // 用作循环变量
		int d, temp; // temp为暂存变量。d为我们分割的子序列数
		int x = 0; // 记录外层变量次数，即我们分成了x层
		for (d = (a.length) / 2; d >= 1; d /= 2) {//计算出分的步数，就是计算每个多少个算一个组。这里一开始是每两个为一组。
			
			for (i = d; i < a.length; i++) { //以计算出来的步数，相隔数来进行循环排序。这个循环的作用是不断地让分组往后面移动，比如1和4为一组的，2和5为一组的。那么i++目的就是往后去遍历每一组
				temp = a[i];
				j = i - 1;
				// 在分好的组内从大往小查找第一个比tmp小的元素，并将tmp放在其后。还是直接插入而已
				for (; j >= 0; j--) {
					if (a[j] > temp) {
						a[j + 1] = a[j];
					} else {
						break;
					}
				}
				a[j + 1] = temp;
			}
			x++;
			System.out.print("第" + (x) + "步排序结果"); // 输出每一步排序的结果
			for (int z = 0; z < a.length; z++) {
				System.out.print(" " + a[z]);
			}
			System.out.print("\n");
		}
	}

	static void shellsort2(int a[]) {
		int j, gap;
		int x = 0; // 记录外层变量次数，就是分组次数

		for (gap = a.length / 2; gap > 0; gap /= 2) {//计算出分的步数，就是计算每个多少个算一个组。这里一开始是每两个为一组。
			for (j = gap; j < a.length; j++) {//以计算出来的步数，相隔数来进行循环排序。这个循环的作用是不断地让分组往后面移动，比如1和4为一组的，2和5为一组的。那么i++目的就是往后去遍历每一组
				//做定点，这个做定点有什么必要呢，我觉得就要看你的数据了，因为做定义也有可能造成耗时挺长的，因为如果这一组（如{1,9,2}）里面的后面有个一个很小的数字，这样会直接跳过此组进行下一组的遍历，最后就要gap=1的一个数字全交换了。
				if (a[j] < a[j - gap])
				{
					int temp = a[j];//暂存变量，作为交换
					int k = j - gap;//标记 a[j - gap]
					//循环这一组，不断往后移动，帮助a[k+gap]找到插入位置，从而进行插入。每个元素与自己组内的数据对比进行直接插入排序
					while (k >= 0 && a[k] > temp) {
						a[k + gap] = a[k];
						k -= gap;
					}
					a[k + gap] = temp;//插入
				}
			}
			x++;
			System.out.print("第" + (x) + "步排序结果，分组次数"); // 输出每一步排序的结果
			for (int z = 0; z < a.length; z++) {
				System.out.print(" " + a[z]);
			}
			System.out.print("\n");
		}
	}
	//冒泡希尔
	static void bubbleShellSort(int a[]) {
		int i, j, gap;
		int x = 0; // 记录外层变量次数，就是分组次数。这里一开始是每两个为一组。
		for (gap = a.length / 2; gap > 0; gap /= 2) {//计算出分的步数，就是计算每个多少个算一个组。
			for (i = gap; i < a.length; i++) {//以计算出来的步数，相隔数来进行循环排序。这个循环的作用是不断地让分组往后面移动，比如1和4为一组的，2和5为一组的。那么i++目的就是往后去遍历每一组
				for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {//在分好的组中进行冒泡排序。就是有多少组相隔多少位的，就冒泡多组。
					int temp = a[j];
					a[j] = a[j + gap];
					a[j + gap] = temp;
				}
			}
			x++;
			System.out.print("第" + (x) + "步排序结果，分组次数"); // 输出每一步排序的结果
			for (int z = 0; z < a.length; z++) {
				System.out.print(" " + a[z]);
			}
			System.out.print("\n");
		}
		
	}

	public static void main(String[] args) {
		int a = (int) (10.5 / 5);
		// TODO Auto-generated method stub
		int[] shuzu = new int[SIZE];
		int i;
		for (i = 0; i < SIZE; i++) {
			shuzu[i] = (int) (100 + Math.random() * (100 + 1)); // 初始化数组
		}
		System.out.print("排序前的数组：\n"); // 输出排序前的数组
		for (i = 0; i < SIZE; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");

		shellsort2(shuzu); // 插入排序操作

		System.out.print("排序后的数组：\n"); // 输出排序后的数组
		for (i = 0; i < SIZE; i++) {
			System.out.print(shuzu[i] + " ");
		}
		System.out.print("\n");
	}

}