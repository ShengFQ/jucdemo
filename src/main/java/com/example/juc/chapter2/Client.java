package com.example.juc.chapter2;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/***
 * 多线程并发之-阻塞队列的运用
 * 生产者和消费者的实现
 * 功能:查找关键字
 *测试功能:
 * 搜索速度
 * 异常
 * @author shengfq
 * @date 20190311
 */

public class Client {
    private static String PATH="/Users/sheng/workspace/github";
    private static final int CORE_SIZE=5,MAX_SIZE=10,FILE_QUEUE_SIZE=100,THREAD_QUEUE_SIZE=100;

    public static void main(String[] args) {
        boolean done=false;
        while(!done) {

            System.out.println("enter base directory:" + PATH);
            String directory = PATH;
            System.out.println("enter keyword");
            Scanner in = new Scanner(System.in);
            String keyword = in.nextLine();
            if("quit".equals(keyword)){
                done=true;
            }
            BlockingQueue<File> fileQueue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
            ExecutorService putPool = ThreadPoolFactory.buildCustomThreadPool();
            ExecutorService takePool=ThreadPoolFactory.buildCustomThreadPool();
            EnumFileTask enumFileTask = new EnumFileTask(new File(directory), fileQueue);
            putPool.execute(enumFileTask);
            SearchKeyTask searchKeyTask=new SearchKeyTask(fileQueue,keyword);
            takePool.execute(searchKeyTask);
            //使用一个线程池运行生产者和消费者的工作线程,会出现,生产者达到了队列边界就阻塞了主进程.消费者线程根本没有执行.
            //使用不同线程池运行生产者和消费者的工作线程,生产者和消费者的执行互相不干扰,不同线程对阻塞队列操作是异步执行的.
        }
        System.out.println("quit!");
    }
}
