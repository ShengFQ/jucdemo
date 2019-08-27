package com.example.designpattern.strategy;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月26日 下午10:45
 */
public interface BaseSimpleStrategy {
    default String pay(){
         getOrder();
         calculate();
         applyPay();
        return "BaseSimpleStrategy";
    }

    void getOrder();
    void calculate();
    void applyPay();
}
