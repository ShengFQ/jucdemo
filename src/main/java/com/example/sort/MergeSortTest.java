package com.example.sort;

/*
 * 对于一个原始的待排序序列，可通过分割的方法来归结为多路合并排序。
 * 而这里是将两个有序表合并成一个有序表，称为二路归并。
 * 
 * 归并排序基本思想：
 * （1）“分解”——将序列每次折半划分
 * （2）“合并”——将划分后的序列段两两合并后排序。
 * 
 * 时间复杂度：
 * 归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的可以得出它的时间复杂度是O(n*log2n)。
 * 空间复杂度：
 * 算法处理过程中，需要一个大小为n的临时存储空间用以保存合并序列。
 * 
 * 稳定的算法。
 */
public class MergeSortTest {
	//接收到分割的单元后，在arrat数组中以分割好的长度进行二路合并，真正实现**合并**是在此！！！
	/*
	 * low ：左数组的第一个元素的索引 
	 * mid ： 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引 
	 * high ：右数组最后一个元素的索引 
	 */
	//比如：gap=1时，Merge每次都是单独把两个长度1的子表进行合并。注意只是一次性地把两个数组合并。
	
	public void Merge(int[] array, int low, int mid, int high) {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列

        // 把较小的数先移到新数组中 。扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
        	//从两个数组中取出最小的放入临时数组  
            if (array[i] <= array[j]) {
                array2[k] = array[i];
                i++;
                k++;
            } else {
                array2[k] = array[j];
                j++;
                k++;
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列，即：把左边剩余的数移入数组
        while (i <= mid) {
            array2[k] = array[i];
            i++;
            k++;
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列，即：把右边边剩余的数移入数组 
        while (j <= high) {
            array2[k] = array[j];
            j++;
            k++;
        }

        // 将合并序列复制到原始序列中，即：把新数组中的数覆盖nums数组  
        for (k = 0, i = low; i <= high; i++, k++) {
            array[i] = array2[k];
        }
    }
	//这里就是分配有序子表，也就是一开始是N个长度为1的有序子表，再到长度为2的....分配好后，循环给Merge方法，在每个分割好后的子表进行合并
    public void MergePass(int[] array, int gap, int length) {
        int i = 0;

        // 归并gap长度的两个相邻子表
        	//i+2*gap-1  其实代表的是数组的最后一位，不过是用这个形式表示而已
        	//i+2*gap-1 其实是每次分组后的两组中的最后一个元素位置
        	//i + gap-1 其实是每次分组后的两组中的第一组的末尾元素位置
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
            System.out.println("每次分隔好数组后，一个个地合并： ");
            this.printAll(array);
        }

        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length) {
            Merge(array, i, i + gap - 1, length - 1);
        }
    }
    //这里是最外层遍历，就是基于长度为gap的若干子序字表去遍历。从n个长度为1的有序子表，到长度为2的有序子表，再到长度4、8
    public int[] sort(int[] list) {
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            MergePass(list, gap, list.length);
            System.out.print("gap = " + gap + ":\t");
            this.printAll(list);
        }
        return list;
    }

    // 打印完整序列
    public void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {
                9, 1, 5, 3, 4, 2, 6, 8, 7
        };

        MergeSortTest merge = new MergeSortTest();
        System.out.print("排序前:\t\t");
        merge.printAll(array);
        merge.sort(array);
        System.out.print("排序后:\t\t");
        merge.printAll(array);
	}

}
