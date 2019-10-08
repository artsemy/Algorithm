package com.company;

import java.math.BigInteger;
import java.util.Random;

class MyClass {

    //find sum of elements (only that multiple to 'k') from mass
    void function1(int k){
        int size = 10;
        int sum = 0;
        int[] mass = createRandomIntMass(size);
        printIntMass(mass);
        System.out.print("elements multiple to " + k + ": ");
        for (int value : mass) {
            if (value % k == 0) {
                System.out.print(value + " ");
                sum += value;
            }
        }
        System.out.println("\nsum = " + sum);
    }

    //create array of integer [0,19]
    private int[] createRandomIntMass(int n){
        int[] mass = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextInt(20);
        }
        return mass;
    }

    //create array of integer [-10, 9]
    private int[] createRandomIntMass2(int n){
        int[] mass = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextInt(20) - 10;
        }
        return mass;
    }

    //create array of double [-5,5)
    private double[] createRandomDoubleMass(int n){
        double[] mass = new double[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            mass[i] = random.nextDouble()*10 - 5;
        }
        return mass;
    }

    //print int array
    private void printIntMass(int[] mass){
        for (int i: mass) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //print double array
    private void printDoubleMass(double[] mass){
        for (double i: mass) {
            System.out.printf("%.2f  ", i);
        }
        System.out.println();
    }

    //replace element that more than 'Z' with 'Z' from array
    //count replaces
    void function2(int Z){
        int size = 10;
        int count = 0;
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

    //count positive, negative and zero elements from double array
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
        System.out.println("pos:" + poz + " neg:" + neg + " zer:" + zer);
    }

    //replace min and max elements in double array
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
        System.out.printf("min= %.2f max= %.2f\n", minElem, maxElem);
        mass[maxIndex] = minElem;
        mass[minIndex] = maxElem;
        printDoubleMass(mass);
    }

    //print elements that more than their index in integer array
    void function5(){
        int size = 10;
        int[] mass = createRandomIntMass2(size);
        printIntMass(mass);
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] > i){
                System.out.print(mass[i] + " ");
            }
        }
    }

    //count sum of elements with prime number indexes, double array
    void function6(){
        int size = 10;
        double[] mass = createRandomDoubleMass(size);
        printDoubleMass(mass);
        double sum  = 0;
        BigInteger bigInteger = new BigInteger("0");
        bigInteger = bigInteger.nextProbablePrime();
        int k = bigInteger.intValue();
        while (k <= mass.length){
            System.out.printf("mass[%d]=%.2f ", k, mass[k]);
            sum += mass[k];
            bigInteger = bigInteger.nextProbablePrime();
            k = bigInteger.intValue();
        }
        System.out.println("\nsum = " + sum);
    }

    //find max sum of center symmetric elements of double array
    void function7(){
        int size = 6;
        double[] mass = createRandomDoubleMass(size*2);
        printDoubleMass(mass);
        double max = mass[0] + mass[mass.length-1];
        System.out.printf("%.2f  ", max);
        for (int i = 1; i < mass.length/2; i++) {
            double max2 = mass[i] + mass[mass.length - 1 - i];
            System.out.printf("%.2f  ", max2);
            max = Double.max(max, max2);
        }
        System.out.println("\nmax = " + max);
    }

    //create new array from another array without its min elements
    void function8(){
        int size = 10;
        int[] mass = createRandomIntMass2(size);
        printIntMass(mass);
        int min = findMin(mass);
        int count = countElem(mass, min);
        System.out.println("min elem " + min + ", number if min elem " + count);
        int[] resMass = new int[mass.length - count];
        int i = 0;
        for (int elem: mass) {
            if(elem != min){
                resMass[i++] = elem;
            }
        }
        printIntMass(resMass);
    }

    //find minimal element in array
    private int findMin(int[] mass){
        int min = mass[0];
        for (int value : mass) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    //count number of elements in array
    private int countElem(int[] mass, int elem){
        int count = 0;
        for (int i: mass) {
            if(i == elem){
                count++;
            }
        }
        return count;
    }

    //find mostly repeated number in array
    //print minimal of them if there two or more founded
    void function9(int size){
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

    //squeeze array - delete every second element, free places set '0'
    void function10(int size){
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
