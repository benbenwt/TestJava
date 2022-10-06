package com.test.multiThread;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread"+Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread"+Thread.currentThread().getName());
    }
}

class MyThread3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "callable";
    }
}
public class TestThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread t1=new MyThread();
        t1.setName("thread-extends");
        t1.start();
        MyThread2 runnable=new MyThread2();
        Thread t2=new Thread(runnable," runnable");
        t2.start();
        MyThread3 callable=new MyThread3();
        FutureTask<String> futureTask=new FutureTask<>(callable);
        Thread t3=new Thread(futureTask);
        t3.start();
        System.out.println(futureTask.get());

        ExecutorService ex=Executors.newSingleThreadExecutor();
        ex.submit(t1);
        ExecutorService ex1=Executors.newFixedThreadPool(4);
        ex1.submit(t1);
        ExecutorService ex2=Executors.newCachedThreadPool();
        ex2.submit(t1);
        ExecutorService ex3=new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1),new ThreadPoolExecutor.AbortPolicy());
        ex3.submit(t1);

        ReentrantLock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        condition.await();

    }
}
