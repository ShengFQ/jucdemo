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
 * • 需要频繁实例化然后销毁的对象。
 * • 创建对象时耗时过多或者耗资源过多,但又经常用到的对象。(LogFactory.mybatis/ErrorContext)
 * • 有状态的工具类对象。
 * • 频繁访问数据库或文件的对象。
 * • 以及其他我没用过的所有要求只有一个对象的场景。
 *------------------------------------
 *  spring容器中的实例默认是单例饿汉式类型的，
 *  * 即容器启动时就实例化bean到容器中，
 *  * 当然也可以设置懒汉式defalut-lazy-init="true"为延迟实例化，
 *  * 用到时再实例化
 *
 * 饿汉一运行就吃内存,懒汉一运行都懒得动
 *
 * 线程安全测试:
 * 多个线程:多个流水线
 * 一个单例:一个包裹
 * 线程内执行单例方法:这个包裹执行共享变量操作
 * @author fuqiang.sheng
 * @date 2019年08月23日 下午9:54
 */
public class Test {

    //计数器

    public static void main(String[] args) {
        //在多线程环境下的访问是否安全.
        for (int i = 0; i < 100; i++) {
            //1个单例资源
            DangerousSingleton singleton=DangerousSingleton.getInstance();
            //100个线程
            Thread t=new Thread(new WorkerThread());
            t.start();
        }
    }

    static class WorkerThread implements  Runnable{
        public WorkerThread(){
           // this.instance=DangerousSingleton.getInstance();
        }
        public WorkerThread(DangerousSingleton instance){
            this.instance=instance;
        }
        DangerousSingleton instance;
        @Override
        public void run()  {
            try {
                //在子线程中创建单例,是否线程安全,结果证明只有一个实例,是线程安全的
                this.instance=DangerousSingleton.getInstance();
                //多线程访问共享数据,每个线程执行+1,如果只有一个实例,那么最终有多少线程,就会自增多少次
                instance.work();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("hash code:"+instance.hashCode()+" count:"+instance.getCount());

        }
    }
}
