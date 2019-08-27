package com.example.designpattern.strategy;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月26日 下午10:25
 */
public interface  SimpleStrategy extends BaseSimpleStrategy{
    /**
     * 实现类会调用直接实现接口的默认方法,而不是调用祖父的默认方法
     * */
    @Override
     default String pay(){
         getOrder();
         calculate();
         applyPay();
        printOrder();
         return "SimpleStrategy";
    }
    /**
     * 打印订单
     * */
    void printOrder();
}
