package com.example.designpattern.singleton;
/**
 * 双重校验锁，线程安全，推荐使用
 * */
public class SafeSingleton {
    private static volatile SafeSingleton singleton;
    private SafeSingleton() {}

    public static SafeSingleton getInstance() {
        if (singleton == null) {
            synchronized (SafeSingleton.class) {
                if (singleton == null) {
                    singleton = new SafeSingleton();
                }
            }
        }
        return singleton;
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