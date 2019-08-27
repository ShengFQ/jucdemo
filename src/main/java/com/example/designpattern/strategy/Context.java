package com.example.designpattern.strategy;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午3:19
 */
public class Context {
    BaseSimpleStrategy strategy;
    public Context(BaseSimpleStrategy strategy){
        this.strategy=strategy;
    }

    public void execute(){
        strategy.pay();
    }
}
