package com.javase.class_package.class_load_order;

public class Confusing {
    public Confusing(Object o) {
        System.out.println("Object");
    }
    public Confusing(double[] dArray) {
        System.out.println("double array");
    }
    public static void main(String args[]) {

            new Confusing(null);

    }
}