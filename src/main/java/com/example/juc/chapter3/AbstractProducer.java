package com.example.juc.chapter3;

abstract class AbstractProducer implements Producer, Runnable {

  public void run() {
    if (true) {
      try {
        produce();
      } catch (InterruptedException e) {
        e.printStackTrace();
       // break;
      }
    }
  }
}