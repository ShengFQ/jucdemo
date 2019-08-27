package com.example.juc.chapter1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QuickEmailToWikiExtractor  {
    /*
    * 消费者线程池
    * */
    private ThreadPoolExecutor threadsPool;
    /**
     * 存放共享资源的阻塞队列
     * */
    private ArticleBlockingQueue<ExchangeEmailShallowDTO> emailQueue;

    /**
     * Cannot instantiate.
     */
    public QuickEmailToWikiExtractor() {
        int corePoolSize=5,maximumPoolSize=10,queue_capacity=100;
        //初始化
        emailQueue= new ArticleBlockingQueue<ExchangeEmailShallowDTO>(queue_capacity);
       // int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        threadsPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 10L, TimeUnit.SECONDS,emailQueue);

    }

    public void extract(){
        long start = System.currentTimeMillis();
        int count_produer=2;
        for (int i = 0; i < count_produer; i++) {
            //new ExtractEmailTask(emailQueue).start();

        }
        threadsPool.execute(new ExtractEmailTask(emailQueue));
        threadsPool.execute(new InsertToWikiTask(emailQueue));
        long end = System.currentTimeMillis();
        double cost = (end - start) / 1000;
        System.out.println("完成, 花费时间：" + cost + "秒");

    }

    public static void main(String[] args) {
        QuickEmailToWikiExtractor quickEmailToWikiExtractor=new QuickEmailToWikiExtractor();
        quickEmailToWikiExtractor.extract();
    }
}
