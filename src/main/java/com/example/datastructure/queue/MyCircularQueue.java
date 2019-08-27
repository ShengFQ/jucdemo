package com.example.datastructure.queue;

/**
 *
 * 循环队列
 * design by Array
 * @author fuqiang.sheng
 * @date 2019年08月01日 下午4:15
 */
public class MyCircularQueue {
    //数组大小
    int size=0;
    //头指针
    int headPointer=-1;
    //尾指针
    int tailPointer=-1;
    //存储数组
    int[] data;
    /**
     *
     * */
   public MyCircularQueue(int capacity){
       data=new int[capacity];
       this.headPointer=-1;
       this.tailPointer=-1;
        this.size=capacity;
   }
    /**
     *返回头部元素,数组为空返回-1
     * */
    public int Front(){
        if (isEmpty()) {
            return -1;
        }
        return data[headPointer];
    }
    /**
     *返回尾部元素,数组为空返回-1
     * */
    public int Rear(){
        if (isEmpty()) {
            return -1;
        }
        return data[tailPointer];
    }

    /**
     * 入队
     *尾部加入一个元素,成功返回true
     * */
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            headPointer=0;
        }
        //TODO 这句代码的意义就是循环队列尾指针移动,不会超过长度的做法,循环指针=(循环指针+1)%size
        tailPointer=(tailPointer+1)%size;
        data[tailPointer]=value;
        return true;
    }
    /**
     * 出队
     *头部删除元素,成功返回true
     * */
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        if(headPointer==tailPointer){
            headPointer=-1;
            tailPointer=-1;
        }
        //TODO 这句代码的意义循环队列头指针移动
        headPointer=(headPointer+1)%size;
        return true;
    }
    /**
     *返回队列是否为空
     * */
    public boolean isEmpty(){
        return headPointer == -1;
    }
    /**
     *返回队列是否已满
     * */
    public boolean isFull(){
      //尾指针等于长度-1
       // return tailPointer==size-1;
        //尾指针向后移动就是头指针位置
        return ((tailPointer + 1) % size) == headPointer;
    }

    public static void main(String[] args) {
        int capacity=10;
        MyCircularQueue queue=new MyCircularQueue(capacity);
        for(int i=0;i<capacity;i++){
            queue.enQueue(i);
            int front=  queue.Front();
            int rear=queue.Rear();
            System.out.println("enqueue front:"+front+" rear:"+rear);
        }

        for(int i=0;i<capacity;i++){
            queue.deQueue();
            int front=  queue.Front();
            int rear=queue.Rear();
            System.out.println("dequeue front:"+front+" rear:"+rear);
        }
    }
}
