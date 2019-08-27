package com.example.designpattern.singleton;

/**
 * 饿汉式，无线程安全问题，不能延迟加载，影响系统性能
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
} 