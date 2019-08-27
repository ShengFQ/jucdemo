package com.example.juc.chapter2;

import java.util.concurrent.*;

/**
 * JUC线程池构造器
 * @author shengfq
 * @date 2019-3-14
 * */
public class ThreadPoolFactory {
    private static final int CORE_SIZE=1,MAX_SIZE=10,CAPACITY_QUEUE=1024;
    private static final long keepAliveTime=0L;
    private static ExecutorService mExecuteorService;
    /**
     * 创建一个固定大小的线程池
     * 主要问题是堆积的请求处理队列可能会耗费非常大的内存,甚至OOM
     * */
    public static ExecutorService buildFixedPool(){
         mExecuteorService=Executors.newFixedThreadPool(CORE_SIZE);
         return mExecuteorService;
    }
    /**
     * 创建一个线程的线程池
     * 主要问题是堆积的请求处理队列可能会耗费非常大的内存,甚至OOM
     * */
    public static ExecutorService buildSingleThreadPool(){
        mExecuteorService=Executors.newSingleThreadExecutor();
        return mExecuteorService;
    }
    /**
     * 创建一个无大小限制的线程池
     * 主要问题是线程最大数量是Integer.MAX_VALUE,可能创建非常多的线程,甚至oom
     * */
    public static ExecutorService buildCachedThreadPool(){
        mExecuteorService=Executors.newCachedThreadPool();
        return mExecuteorService;
    }
    /**
     * 主要问题是线程最大数量是Integer.MAX_VALUE,可能创建非常多的线程,甚至oom
     * */
    public static ExecutorService buildScheduleThreadPool(){
        mExecuteorService=Executors.newScheduledThreadPool(CORE_SIZE);
        return mExecuteorService;
    }

    /**
     * 推荐自定义 参数能够动态调节
     * */
    public static ExecutorService buildCustomThreadPool(){
        ThreadFactory namedThreadFactory=new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("thread_customer");
                return thread;
            }
        };
        mExecuteorService=new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE,keepAliveTime, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>
                        (CAPACITY_QUEUE),namedThreadFactory);
        return mExecuteorService;
    }
    /**
     * springframework 也提供了线程池的实现
     * org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
     * */

}
