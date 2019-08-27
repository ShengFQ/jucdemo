package com.example.juc.chapter2;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者线程:
 * 枚举目标文件夹下的所有子文件
 * */
public class EnumFileTask implements Runnable{
    public static File DUMMY=new File("");
    private File root;
    private BlockingQueue<File> queue;
    //1.阻塞队列存放目标文件夹下的所有文件
    //2.用一个结束对象标明生产者已经结束
    public EnumFileTask(File root,BlockingQueue<File> target){
        this.root=root;
        this.queue=target;
    }

    public void run() {
        try {
            enumFile(root);
            queue.put(DUMMY);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    private void enumFile(File root)  {
        File[] files=root.listFiles();
        for (File file:files ) {
            if(file.isDirectory()){
                enumFile(file);
            }else {
                if(file.getPath().endsWith("txt")) {
                    try {
                        queue.put(file);
                        System.out.println("将文件[" + file + "]添加到队列");
                        System.out.println("queue size:"+queue.size());
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }else{
                   // System.out.println("排除文件:"+file.getPath());
                }
            }
        }
    }
}
