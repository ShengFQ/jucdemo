package com.example.designpattern.template;

/**
 * 文件描述
 *
 * @author fuqiang.sheng
 * @date 2019年08月27日 下午5:25
 */
public class ConcreteTemplateA extends AbsTemplate{
    @Override
    void setStepOne() {
        System.out.println("ConcreteTemplateA.setStepOne");
    }

    @Override
    void setStepTwo() {
        System.out.println("ConcreteTemplateA.setStepTwo");
    }

    @Override
    void setStepThree() {
        System.out.println("ConcreteTemplateA.setStepThree");

    }
    @Override
    public void tag(){
        super.tag();
        System.out.println("ConcreteTemplateA.tag");

    }
}
