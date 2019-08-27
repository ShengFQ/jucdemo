package com.example.designpattern.proxy;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月24日 上午8:26
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("this is RealSubject.request");
    }
}
