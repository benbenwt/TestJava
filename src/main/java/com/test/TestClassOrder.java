package com.test;

class Parent{
    static {
        System.out.println("static code block parent");
    }
    {
        System.out.println("code block parent");
    }
    public Parent(){
        System.out.println("Parent constructor");
    }

    public Parent(String name){
        System.out.println("Parent name constructor");
    }
}
public class TestClassOrder extends Parent {
    static {
        System.out.println("static TestClassOrder");
    }
    {
        System.out.println("code block TestClassOrder ");
    }
     public TestClassOrder(){
        super();
        System.out.println("TestClassOrder constructor");
    }
    public TestClassOrder(String name){
        super(name);
        System.out.println("TestClassOrder name constructor");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.test.Parent");
        System.out.println("----");
        TestClassOrder t=new TestClassOrder();
        System.out.println("----");
        TestClassOrder t1=new TestClassOrder("hello");
    }
}
