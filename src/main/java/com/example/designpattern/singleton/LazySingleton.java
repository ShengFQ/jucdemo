package com.example.designpattern.singleton;

/**
 * 懒汉式单例
 * 线程不安全，不可用
 * */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}
  
    public static LazySingleton getInstance() {
    if (instance == null) {  
        instance = new LazySingleton();
    }  
    return instance;  
    }



    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void plusplus(){
        this.count++;
    }

    public void mecy(){
        this.count--;
    }
    //测试数据是否安全,如果真的只有一个实例,那么count就是只有一个内存地址
    private Integer count=0;
} 