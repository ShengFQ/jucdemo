package com.example.designpattern.strategy;

/**
 * 算法的具体成员A
 *
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午2:41
 */
public class ConcreteStrategyB implements SimpleStrategy {
    @Override
    public void printOrder() {
        System.out.println("ConcreteStrategyB.printOrder");
    }

    @Override
    public void getOrder() {
        System.out.println("ConcreteStrategyB.getOrder");

    }

    @Override
    public void calculate() {
        System.out.println("ConcreteStrategyB.calculate");

    }

    @Override
    public void applyPay() {
        System.out.println("ConcreteStrategyB.applyPay");

    }
}
