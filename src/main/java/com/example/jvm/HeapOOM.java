package com.example.jvm;

import java.util.ArrayList;
import java.util.List;
/**
 * 手动制造OOM 查看堆栈
 * */
public class HeapOOM {
    public static void main(String[] args) {
               List<String> list = new ArrayList<String>(10) ;
                while (true){
                        list.add("1") ;
                    }
            }
}
