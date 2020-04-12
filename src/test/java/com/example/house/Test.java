package com.example.house;

import com.example.house.Entity.Street;

public class Test {
    int i ;
    public  static void main(String[] args) {
        TestJc testJc = new TestJc();
        Street street = new Street();
        Street street2 = new Street();
        street.setName("2323");
        System.out.println(street.getName().hashCode());
        System.out.println(street2.hashCode());
        System.out.println(street.equals(street2));
        a(1);
    }

    private static int a(int x) {
        int in;
        return 0;
    }

    private static String a(String x) {
        return "2";
    }

    private static char a(char a) {

        return 'a';
    }
}
