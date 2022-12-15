package com.test.innerclass;

public class OuterClass {
     class InnerClass{
        int y=1;
    }

    public static void main(String[] args) {
        OuterClass o=new OuterClass();
        OuterClass.InnerClass i=o.new InnerClass();
    }
}
