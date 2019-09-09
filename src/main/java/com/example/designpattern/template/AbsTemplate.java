package com.example.designpattern.template;

/**
抽象模板类,定义一些抽象的方法,子类去实现
 容易扩展。一般来说,抽象类中的模版方法是不易反生改变的部分,而抽象方法是容易反生变化的部分,因此通
 过增加实现类一般可以很容易实现功能的扩展,符合开闭原则
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午5:18
 */
public abstract class AbsTemplate {
    /**
     * 要素1
     * 抽象方法
     * */
    abstract void setStepOne();
    abstract void setStepTwo();
    abstract void setStepThree();
    /**
     * 要素2
     * 模板方法,大多不能被重写
     * */
    public final void print(){
        System.out.println("hello,this is AbsTemplate,enter first!!");
        setStepOne();
        setStepTwo();
        setStepThree();
        tag();
    }
    /**
     * 要素3
     * 钩子方法,可以被重写,但是要注意
     * */
    public void tag(){
        System.out.println("hello,this is AbsTemplate,enter end!!");

    }
}
