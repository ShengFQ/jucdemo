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
} 