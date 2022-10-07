package com.test.proxy;

import java.util.Timer;

public class NowTime implements NowTimeInterface{
    public  void printTime(){
        System.out.println(System.currentTimeMillis());
    }
}
