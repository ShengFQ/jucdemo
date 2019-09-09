package com.example.designpattern.singleton;
/**
 * 线程安全，同步方法，效率低，不推荐
 * */
public class LazySingleton2 {
    private static LazySingleton2 instance;
    private LazySingleton2(){}
    public static synchronized LazySingleton2 getInstance() {
    if (instance == null) {  
        instance = new LazySingleton2();
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