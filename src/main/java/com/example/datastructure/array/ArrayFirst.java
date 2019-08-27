package com.example.datastructure.array;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目来自力扣
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/21/
 * @author fuqiang.sheng
 * @date 2019年08月02日 上午11:38
 */
public class ArrayFirst {
   static int[] dumplicateArray={1,1,1,2,2,3,3,5,6};
   static int[] rotateArray={1,2,1,2,3,3};
   static int[] targetArray={9,9,8};
   static int[] temperatures ={73, 74, 75, 71, 69, 72, 76, 73};
   static void printResult(int[] array){
       for(int i=0;i<array.length;i++){
           System.out.print("\t"+array[i]);
       }
       System.out.println();
   }
    /**
     * TODO 数组去重
     * 从排序数组中删除重复项,返回数组新的长度
     * 不要使用额外的数组空间,数组长度是不可改变的,那也就是
     * 从0-new_length,并不改变数组大小
     * */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //////////////////////数组旋转
        /**
     * 双重循环
     * 时间复杂度：O(k*n)
     * 空间复杂度：O(1)
     */
    public void rotate_1(int[] nums, int k) {
        int n = nums.length;
        //TODO 一个算术,如果k是n的约数,k就等于0不需要旋转
        k %= n;
        System.out.println("k:"+k);
        //for循环,移动多少步
        for (int i = 0; i < k; i++) {
            //最后一个元素
            int temp = nums[n - 1];
            //for循环,所有元素向右移动一步
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            //最后一个元素放第一位
            nums[0] = temp;
        }
    }


    /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 递归交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(n/k)
     */
    public void rotate_4(int[] nums, int k) {
        // 原理同上
        recursiveSwap(nums, k, 0, nums.length);
    }

    private void recursiveSwap(int[] nums, int k, int start, int length) {
        k %= length;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            recursiveSwap(nums, k, start + k, length - k);
        }
    }
    ////////////////////数组旋转
    /**
     * 是否存在重复元素
     * 类似于排序,每个元素都要遍历到,存在相同立即返回
     * */
    public boolean containsDuplicate(int[] nums) {
        boolean result=false;
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]==nums[j]){
                    System.out.println("dump:"+nums[j]);
                    return true;
                }
            }
        }
        return result;
    }
    /**
     * 输出只出现过一次的数组元素,也就是不重复的元素
     * */
    public int singleNumber(int[] nums) {
        int length=nums.length;
        int result=1;
        for(int i=0;i<length;i++){
            result^=nums[i];
        }
        return result;
    }
    /**
     * 两个数组的交集 II
     * */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            System.out.printf("i={%d},j={%d}\n",i,j);
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    /**
     * 优雅的写法
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * */
    public int[] plusOne(int[] digits) {
        //题意只会进行加1操作,两种情况,末尾非9,末尾为9. 非9情况直接加一,末尾为9,进一位,末位为0
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //n%=k的作用:1.旋转最终步数 2.进制位数变化
            digits[i] = digits[i] % 10;
            System.out.print("\tdigits:"+digits[i]);
            //遇到为0的情况,高位补1
            if (digits[i] != 0) {return digits;}
        }
        //如果都为0,表示最高位进位,扩大数组长度
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * */
    public void moveZeroes(int[] nums) {

    }
    /**
     * 每日温度
     * https://leetcode-cn.com/problems/daily-temperatures/solution/jie-ti-si-lu-by-pulsaryu/
     * */
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayFirst first=new ArrayFirst();
        int[] result=first.dailyTemperatures(temperatures);

        System.out.println(new Gson().toJson(result));
    }
}
