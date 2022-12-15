package com.test.collections;

import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer>  l1=new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        while(l1.iterator().hasNext())
        {
            l1.iterator().remove();
        }
//        for(int i=0;i<l1.size();i++)
//        {
//            l1.remove(i);
//        }
//        java.util.ConcurrentModificationException
        for(Integer i :l1)
        {
            l1.remove(i);
        }

    }
}
