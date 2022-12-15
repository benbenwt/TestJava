package com.test;


public class TestString {
    public static void main(String[] args) {
        Object [] a=new Object[10];
        a[0]=new Integer(1);
        a[1]="hello";
        System.out.println(a[0]);
        System.out.println(a[1]);

        String str1="hello";
        String str2="hello";
        String str3=new String("hello");
        String str4=new String("hello");
        System.out.println(str3==str4);
        System.out.println(str1==str2);
        System.out.println(str1.intern()==str1);
//        String strs="计算机软件";
        String str5=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str5.intern()==str5);

        String str52=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str52.intern()==str52);

        String str53=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str53.intern()==str5);

        String str6=new StringBuilder("ja").append("va").toString();
        System.out.println(str6.intern()==str6);

        Boolean b=true;
        Integer i1=new Integer(1);
        Integer i2=new Integer(1);

        System.out.println(i1==i2);
    }
}
