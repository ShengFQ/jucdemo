package com.example.datastructure.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 文件描述
 * 无序不重复的Set集合
 * @author fuqiang.sheng
 * @date 2019年08月07日 下午10:26
 */
public class HashSetTest {
    static Set<String> set = new HashSet<String>();
    private static void add(){
        set.add("a");
        set.add("b");
        set.add("c");
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String str = (String) iter.next();
            System.out.println(str);
        }
        System.out.println("size:"+set.size());
    }

    private static void addElement(){
        add();
    }
    public static void main(String[] args) {
        addElement();
        addElement();
    }
}
