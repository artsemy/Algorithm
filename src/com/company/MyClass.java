package com.company;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

class MyClass {

    void function1(){
        int size = 10;
        int sum = 0;
        int k = 3;
        int[] mass = createRandomIntMass(size);
        for (int value : mass) {
            if (value % k == 0) {
                sum += value;
            }
        }
        printIntMass(mass);
        System.out.println("sum = " + sum);
    }

    private int[] createRandomIntMass(int n){
        int[] mass = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextInt(20);
        }
        return mass;
    }

    private int[] createRandomIntMass2(int n){
        int[] mass = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextInt(20) - 10;
        }
        return mass;
    }

    private double[] createRandomDoubleMass(int n){
        double[] mass = new double[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextDouble()*10 - 5;
        }
        return mass;
    }

    private void printIntMass(int[] mass){
        System.out.println(Arrays.toString(mass));
    }
    private void printDoubleMass(double[] mass){
        System.out.println(Arrays.toString(mass));
    }

    void function2(){
        int size = 10;
        int count = 0;
        int Z = 10;
        int[] mass = createRandomIntMass(size);
        printIntMass(mass);
        for (int i = 0; i <mass.length ; i++) {
            if(mass[i] > Z){
                mass[i] = Z;
                count++;
            }
        }
        printIntMass(mass);
        System.out.println("count = " + count);
    }

    void function3(){
        int size = 10;
        double[] mass = createRandomDoubleMass(size);
        int poz = 0;
        int neg = 0;
        int zer = 0;
        printDoubleMass(mass);
        for (double d: mass) {
            if(d > 0){
                poz++;
            } else if(d < 0){
                neg++;
            } else {
                zer++;
            }
        }
        System.out.println("poz:" + poz + " neg:" + neg + " zer:" + zer);
    }

    void function4(){
        int size = 10;
        double[] mass = createRandomDoubleMass(size);
        double maxElem = mass[0];
        double minElem = mass[0];
        int maxIndex = 0;
        int minIndex = 0;
        printDoubleMass(mass);
        for (int i = 1; i < mass.length; i++) {
            if(mass[i] > maxElem){
                maxElem = mass[i];
                maxIndex = i;
            }
            if(mass[i] < minElem){
                minElem = mass[i];
                minIndex = i;
            }
        }
        mass[maxIndex] = minElem;
        mass[minIndex] = maxElem;
        printDoubleMass(mass);
    }

    void function5(){
        int size = 10;
        int[] mass = createRandomIntMass2(size);
//        printIntMass(mass);
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] > i){
                System.out.print(mass[i] + " ");
            }
        }
    }

    void function6(){
        int size = 10;
        double[] mass = createRandomDoubleMass(size);
        printDoubleMass(mass);
        double sum  = 0;
        BigInteger bigInteger = new BigInteger("0");
        bigInteger = bigInteger.nextProbablePrime();
        int k = bigInteger.intValue();
        while (k <= mass.length){
            sum += mass[k];
            bigInteger = bigInteger.nextProbablePrime();
            k = bigInteger.intValue();
        }
        System.out.println("sum = " + sum);
    }

    void function7(){
        int size = 5;
        double[] mass = createRandomDoubleMass(size*2);
        printDoubleMass(mass);
        double max = mass[0] + mass[mass.length-1];
        for (int i = 1; i < mass.length/2; i++) {
            max = Double.max(max, mass[i] + mass[mass.length - 1 - i]);
        }
        System.out.println("max = " + max);
    }

    void function8(){
        int size = 10;
        int[] mass = createRandomIntMass(size);
        printIntMass(mass);
        int min = findMin(mass);
        int count = countElem(mass, min);
        int[] resMass = new int[mass.length - count];
        int i = 0;
        for (int elem: mass) {
            if(elem != min){
                resMass[i++] = elem;
            }
        }
        printIntMass(resMass);
    }

    private int findMin(int[] mass){
        int min = mass[0];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < min) {
                min = mass[i];
            }
        }
        return min;
    }

    private int countElem(int[] mass, int elem){
        int count = 0;
        for (int i: mass) {
            if(i == elem){
                count++;
            }
        }
        return count;
    }

    void function9(){
        int size = 10;
        int[] mass = createRandomIntMass2(size);
        printIntMass(mass);
        int elem = mass[0];
        int count = countElem(mass, elem);
        for (int i: mass) {
            int count2 = countElem(mass, i);
            if (count2 > count){
                elem = i;
                count = count2;
            }
            if(count == count2){
                elem = Integer.min(elem, i);
            }
        }
        System.out.println("elem:" + elem + " times:" + count);
    }

    void function10(){
        int size = 4;
        int[] mass = createRandomIntMass2(size);
        printIntMass(mass);
        for (int i = 1; i < (int) Math.ceil(mass.length/2.); i++) {
            mass[i] = mass[2*i];
        }
        for (int i = (int) Math.ceil(mass.length/2.); i < mass.length; i++) {
            mass[i] = 0;
        }
        printIntMass(mass);
    }

}
