package com.example.apache.commons;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月16日 下午7:35
 */
public class RandomUtilsTest {
    /**
     * 生成一个大于min,小于max的随机整数
     * */
    private static int getRamdonNum(int min,int max){
        return min + (int)(Math.random() * (max-min+1));
    }
    private static int getRamdonNum2(int min,int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private static int getRamdonNum3(int min,int max){
        return RandomUtils.nextInt(min,max);
    }


    private static long getRamdonNum4(int min,int max){
        return RandomUtils.nextLong(min,max);
    }


    private static double getRamdonNum5(int min,int max){
        return RandomUtils.nextDouble(min,max);
    }


    private static float getRamdonNum6(int min,int max){
        return RandomUtils.nextFloat(min,max);
    }

    private static String getRamdonString(int count){
        return RandomStringUtils.randomNumeric(count);
    }


    private static String getRamdonString2(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }

    private static String getRamdonString3(int count){
        return RandomStringUtils.randomAlphanumeric(count);
    }
    public static void main(String[] args) {
        int result=getRamdonNum(0,10);
        System.out.println(result);

        int result2=getRamdonNum2(0,10);
        System.out.println(result2);

        int result3=getRamdonNum3(0,10);
        System.out.println(result3);
    }
}
