package com.example.juc.chapter2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者线程
 * 对文件进行逐行匹配关键字
 * */
public class SearchKeyTask implements Runnable{
    private String keyword;
    private BlockingQueue<File> queue;
    public SearchKeyTask(BlockingQueue<File> target,String keyword){
        this.queue=target;
        this.keyword=keyword;
    }
    public void run() {
        try{
            boolean done=false;
            while(!done){
                File file=queue.take();
                System.out.println("queue size:"+queue.size());
                if(file==EnumFileTask.DUMMY){
                    done=true;
                    System.out.println("搜索完成");
                }else if(file.isDirectory()){
                    done=true;
                    System.out.println("文件队列文件为目录");
                }else if(!file.exists()){
                    done=true;
                    System.out.println("文件不存在");
                }else{
                    search(file);
                }
            }
        }catch(InterruptedException ex){

        }
    }

    private void search(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner in=new Scanner(fileInputStream);
            int lineNumber=0;
            while (in.hasNextLine()){
                lineNumber++;
               String line= in.nextLine();
               if(line.contains(keyword)){
                   System.out.printf("#################file:%s:line:%d:%s%n",file.getPath(),lineNumber,line);
               }
            }
            in.close();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
