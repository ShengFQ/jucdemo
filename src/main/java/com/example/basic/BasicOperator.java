package com.example.basic;

/**
 * 基本的逻辑运算符
 * @author fuqiang.sheng
 * @date 2019年08月02日 下午5:04
 */
public class BasicOperator {
    private boolean a=false,b=false;
    private boolean isA(){
        return a;
    }
    private boolean isB(){
        return b;
    }

    public static void main(String[] args) {
        BasicOperator operator=new BasicOperator();
       // System.out.println(!operator.isA());
       // System.out.println(operator.isA()&& operator.isB());
        System.out.println(0 ^ 12 );//n
        System.out.println(12 ^12);//0
        System.out.println(1 ^1 ^2^2^3);//3

    }
}
