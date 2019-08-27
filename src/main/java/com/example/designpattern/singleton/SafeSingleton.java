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
} 