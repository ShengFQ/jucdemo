package com.example.designpattern.singleton;

/**
 * 线程不安全，会产生多个实例，不可用
 * @date 2019年08月23日21:48:33
 * */
public class DangerousSingleton {
    private static DangerousSingleton singleton;
	private DangerousSingleton() {}

    public static DangerousSingleton getInstance() {
        if (singleton == null) {
            synchronized (DangerousSingleton.class) {
                singleton = new DangerousSingleton();
            }
        }
        //验证是否是同一个实例
        System.out.println(" context hashCode:"+singleton.hashCode());
        return singleton;
    }



    //测试数据是否安全
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count=0;
}
