package com.test;

import java.util.ArrayList;
import java.util.List;

public class TestException {
    public static void main(String[] args) {
        boolean i=new TestException().test();
        System.out.println(i);
    }
    public boolean test(){
        int i=0;
        Integer in=new Integer(0);
        Boolean b=true;
        List<Integer> list=new ArrayList<>();
        list.add(2);
        try {
            i++;
            in++;
            System.out.println("try : "+i);
            System.out.println("try in: "+in);
            return b;
        } catch (Exception e) {
            i++;
            in++;
            System.out.println("catch : "+i);
            System.out.println("catch in: "+in);
            e.printStackTrace();
        }finally {
            b=false;
            i=3;
            in=3;
            list.add(1);
            System.out.println("finally : "+i);
            System.out.println("finally in: "+in);
        }
        return b;
    }
}
