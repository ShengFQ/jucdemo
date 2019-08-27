package com.example.designpattern.proxy;

/**
 * 动态代理的目标实例,没有实现ISubject接口,但是有相同的方法
 *
 * @author fuqiang.sheng
 * @date 2019年08月25日 下午3:28
 */
public class UserSubject implements ISubject {
   public void request(){
       System.out.println("UserSubject.request");
    }
}
