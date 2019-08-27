package com.example.juc.chapter1;

import java.util.concurrent.LinkedBlockingQueue;
/**
 * 定制化的阻塞队列,可以按照元素的属性进行排序等操作
 * */
public class ArticleBlockingQueue<ExchangeEmailShallowDTO> extends LinkedBlockingQueue {
    public ArticleBlockingQueue(int capacity){
        super(capacity);
    }
}
