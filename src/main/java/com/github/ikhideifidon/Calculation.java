package com.github.ikhideifidon;

public class Calculation {
    int z;
    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers is: " + z);
    }
     public void subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference of the given numbers is: " + z);
     }
}

class MyCalculation extends Calculation {
    int z = 5;
    public void multiplication(int x, int y) {
        super.z = x * y;
        System.out.println("The product of the given numbers is: " + super.z);
    }

    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        Calculation demo1 = new MyCalculation();
        System.out.println(demo1.z);

        Calculation demo2 = new MyCalculation();
        demo2.subtraction(a, b);
    }
}


