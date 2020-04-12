package com.example.house;

public class ChongXie  {

    ChongXie(){
        System.out.println(1);
    }
    public int aInt= 1;
    private String s = "父类私有变量";

    private void a() {
        System.out.println("父类私有方法");
    }

    Object chongxie2() {
        System.out.println("chongxie2");
        return null;
    }

}
