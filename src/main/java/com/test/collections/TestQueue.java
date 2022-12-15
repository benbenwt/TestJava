package com.test.collections;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> q1=new PriorityQueue<>();
        q1.offer("a");
        System.out.println(q1.poll());
        Stack<String> s1=new Stack<>();
        s1.push("s");
        System.out.println(s1.pop());
        AbstractQueuedSynchronizer a;
        Executor e;
    }
}
