package com.example.datastructure.list;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 文件描述
 * ArrayList和Vector是基于数组实现的，LinkedList是基于双向链表实现的。
 * ArrayList和LinkedList是线程不安全的，Vector是线程安全的。
 * 如果要在并发环境下使用ArrayList或者LinkedList，可以调用Collections类的synchronizedList()方法：
 * 扩容机制:使用的方法是Arrays.copyOf()，其中ArrayList扩容后的容量是之前的1.5倍，Vector默认情况下扩容后的容量是之前的2倍
 *
 * @author fuqiang.sheng
 * @date 2019年08月07日 下午7:06
 */
public class TestList {
   static List<Student> studentList=new ArrayList<Student>();

    public static void main(String[] args) {
        Student s1=new Student("a",1);
        Student s2=new Student("b",2);
        Student s3=new Student("c",3);
        Student s4=new Student("a",4);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        System.out.println("contain reference:"+studentList.contains(s1));
        System.out.println("contain value:"+studentList.contains(s4));
        System.out.println("indexof:"+studentList.indexOf(s2));
       // System.out.println("remove:"+studentList.remove(s4));
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               return o1.getAge().intValue()-o2.getAge().intValue();
            }
        });
        System.out.println("list:"+new Gson().toJson(studentList));
    }
}

class Student{
    private String name;
    private Integer age;
    public Student(String name,Integer age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}