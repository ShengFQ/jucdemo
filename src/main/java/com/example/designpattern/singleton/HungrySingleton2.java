package com.example.designpattern.singleton;
/**
 * 饿汉式，无线程安全问题，不能延迟加载，影响系统性能
 * */
public class HungrySingleton2 {
    private static HungrySingleton2 instance = null;
    static {  
		instance = new HungrySingleton2();
    }  
    private HungrySingleton2(){}
    public static HungrySingleton2 getInstance() {
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