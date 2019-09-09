package com.example.designpattern.singleton;

/**
 * 线程安全
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
        //singleton = new DangerousSingleton();
        //验证是否是同一个实例
        return singleton;
    }



    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void work(){
	    plusplus();
	   // mecy();
    }
    private   void plusplus(){
	    this.count++;
    }

    private  void mecy(){
	    this.count--;
    }
    //测试数据是否安全,如果真的只有一个实例,那么count就是只有一个内存地址
    private Integer count=0;
}
