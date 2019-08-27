package com.example.juc.chapter3;

abstract class AbstractConsumer implements Consumer, Runnable {

  public void run() {
    if (true) {
      try {
        consume();
      } catch (InterruptedException e) {
        e.printStackTrace();
       // break;
      }
    }
  }
}