package com.example.designpattern.singleton;

/**
 * 文件描述
 * 考虑多线程问题
 * 如果类可序列化，考虑反序列化生成多个实例问题，解决方案如下
 * private Object readResolve() throws ObjectStreamException {
 * 	// instead of the object we're on, return the class variable INSTANCE
 * 	return INSTANCE;
 * }
 *
 * 单例的使用场景
 * 使用场景
 * 1、工具类对象
 * 2、系统中只能存在一个实例的类
 * 3、创建频繁或又耗时耗资源且又经常用到的对象
 *------------------------------------
 *  spring容器中的实例默认是单例饿汉式类型的，
 *  * 即容器启动时就实例化bean到容器中，
 *  * 当然也可以设置懒汉式defalut-lazy-init="true"为延迟实例化，
 *  * 用到时再实例化
 *
 * 饿汉一运行就吃内存,懒汉一运行都懒得动
 * @author fuqiang.sheng
 * @date 2019年08月23日 下午9:54
 */
public class Test {
    //饿汉单例,类加载就吃内存,懒汉单例,类加载不会吃内存
    private Test(){}
    public static Test hungury=new Test();
    public static Test getInstance(){
       return hungury;
    }


    public static Test lazy;
    public static Test getLazy(){
        if(lazy==null){
            synchronized (Test.class){
                if(lazy==null){
                    lazy=new Test();
                }
            }
        }
        return lazy;
    }


    public static void main(String[] args) {

    }
}
