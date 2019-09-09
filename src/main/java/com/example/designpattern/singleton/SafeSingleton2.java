package com.example.designpattern.singleton;
/**
 * 静态内部类，线程安全，主动调用时才实例化，延迟加载效率高，推荐使用
 * */
public class SafeSingleton2 {
    private static class SingletonHolder {  
		private static final SafeSingleton2 INSTANCE = new SafeSingleton2();
    }  
    private SafeSingleton2(){}
    public static final SafeSingleton2 getInstance() {
		return SingletonHolder.INSTANCE;  
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