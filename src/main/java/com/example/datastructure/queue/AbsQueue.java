package com.example.datastructure.queue;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月07日 下午5:58
 */
public class AbsQueue implements Queue {
    //////////from Collection
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


    ////////////////from Queue
    @Override
    public boolean add(Object o) {
        return false;
    }
    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    public static void main(String[] args) {
        int capacity=10;
        Queue<Integer> queue=new ConcurrentLinkedQueue<Integer>();
        for(int i=0;i<capacity;i++){
            queue.add(i);
            //如果队列为空则抛出异常,否则返回头部
            int result=queue.element();
            System.out.println("element:"+result);
        }
        System.out.println("queue:"+new Gson().toJson(queue));
        for(int i=0;i<capacity;i++){
            //如果队列为空,则返回空,否则返回头部
           int front= queue.peek();
            System.out.println("peek front:"+front);
        }
        System.out.println("queue:"+new Gson().toJson(queue));
        for(int i=0;i<capacity;i++){
            boolean result= queue.offer(i);
            System.out.println("offer front:"+result);
        }
        System.out.println("queue:"+new Gson().toJson(queue));
        for(int i=0;i<capacity;i++){
            int result= queue.remove();
            System.out.println("remove front:"+result);
        }
        System.out.println("queue:"+new Gson().toJson(queue));
        for(int i=0;i<capacity;i++){
            //删除并返回头部元素
            int result= queue.poll();
            System.out.println("poll front:"+result);
        }
        System.out.println("queue:"+new Gson().toJson(queue));

    }
}
