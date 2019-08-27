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
} 