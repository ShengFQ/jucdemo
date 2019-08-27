package com.example.sort;

// 代码一般，但是他的演示过程很值得我们去看！！http://www.tuicool.com/articles/y6Bbq2u
/*
 * 基本思想就是：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 * 
 * 基数排序有两种方法：
 * 最高位优先法（MSD）(Most Significant Digit first)
 * 最低位优先法（LSD）(Least Significant Digit first)
 * 基数排序是稳定的排序算法，它的平均时间复杂程度为：O(d(r+n))，空间复杂度为：O（rd+n）。
 */
public class RadixSortTest {

	// 获取x这个数的d位数上的数字
    // 比如获取123的1位数，结果返回3
    public int getDigit(int x, int d) {
        int a[] = {
                1, 1, 10, 100
        }; // 本实例中的最大数是百位数，所以只要到100就可以了
        return ((x / a[d]) % 10);
    }
 
    public void radixSort(int[] list, int begin, int end, int digit) {
        final int radix = 10; // 基数
        int i = 0, j = 0;
        int[] count = new int[radix]; // 存放各个桶的数据统计个数,count用于记录待排序元素的信息,用来表示该位是i的数的个数 
        int[] bucket = new int[end - begin + 1];
 
        // 按照从低位到高位的顺序执行排序过程，也就是从个位开始排序，再到十位，这里传d=3，所以是排序到百位。
        for (int d = 1; d <= digit; d++) {
 
            // 置空各个桶的数据统计
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }
 
            // 统计各个桶将要装入的数据个数
            for (i = begin; i <= end; i++) {
                j = getDigit(list[i], d);
                count[j]++;
            }
 
            // count[i]表示第i个桶的右边界索引！！！是右边界，所以我们从每个桶右边开始放元素。
          //统计count数组的前i位（包含i）共有多少个数
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
 
            // 将数据依次装入桶中
            // 这里要从右向左扫描，保证排序稳定性
            for (i = end; i >= begin; i--) {
                j = getDigit(list[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5
                bucket[count[j] - 1] = list[i]; // 放入对应的桶中，count[j]-1是第j个桶的右边界索引
                count[j]--; // 对应桶的装入数据索引减一 
            }
           

            // 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
            for (i = begin, j = 0; i <= end; i++, j++) {
                list[i] = bucket[j];
            }
            System.out.print("-----第" + (d) + "次：---\n"); 
            printAll(list);
            
        }
    }
 
    public int[] sort(int[] list) {
        radixSort(list, 0, list.length - 1, 3);
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
        int[] array = {
                50, 123, 543, 187, 49, 30, 0, 2, 11, 100,1589
        };
        RadixSortTest radix = new RadixSortTest();
        System.out.print("排序前:\t\t");
        radix.printAll(array);
        radix.sort(array);
        System.out.print("排序后:\t\t");
        radix.printAll(array);
    }

}
