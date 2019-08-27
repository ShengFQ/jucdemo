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
} 