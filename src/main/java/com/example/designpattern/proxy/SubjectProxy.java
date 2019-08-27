package com.example.designpattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * jdk动态代理类的实现
 * @author fuqiang.sheng
 * @date 2019年08月24日 上午8:50
 */
public class SubjectProxy  {
    /**
     * 创建代理对象方法一
     * @param target 目标对象
     * */
    public static Object loadProxy1(Object target) throws Exception{

        //通过接口Class对象创建代理Class对象
        Class<?> proxyClass= Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());

        //拿到代理class对象的有参构造函数
        Constructor<?> constructors=proxyClass.getConstructor(InvocationHandler.class);
        //反射创建代理对象,JDK底层代码对Object进行了分类处理
        Object proxy=constructors.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke before...");
                Object result= method.invoke(target,args);
                System.out.println("invoke after ...\n" +
                        "");
                return result;
            }
        });
        //TODO 打印代理对象的属性信息
        System.out.println("执行日志..."+(proxy instanceof Proxy)+"\n");
        System.out.println("执行日志..."+(proxyClass.getName())+"\n");
        System.out.println("执行日志..."+(proxyClass.getSuperclass().getName())+"\n");
        System.out.println("执行日志..."+(proxyClass.getSuperclass().getSimpleName())+"\n");
        System.out.println("执行日志..."+(proxyClass.getInterfaces()[0].getSimpleName())+"\n");

        return proxy;
    }

    public static Object loadProxy2(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(), //和目标对象的类加载器保持一致
                object.getClass().getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成代理对象
                new InvocationHandler() { //事件处理器，即对目标对象方法的执行

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("执行前日志...");

                        Object result = method.invoke(object, args);

                        System.out.println("执行后日志...");
                        return result;
                    }
                });
    }

    public static void write(Object target){
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", target.getClass().getInterfaces());
        String path = "/Users/sheng/Desktop/com/sun/proxy/SubjectProxy.class";

        try{
            File file=new File(path);
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写文件错误");
        }
    }





}
