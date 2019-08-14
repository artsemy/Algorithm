package com.company;

class MyClass4 {

    void function1a(int a, int b){
        System.out.print("The greatest common divisor of " + a + " and " + b);
        int c = Math.max(a, b) % Math.min(a, b);
        b = Math.min(a, b);
        while(c!= 0){
            a = Math.max(b, c);
            b = Math.min(b, c);
            c = a % b;
        }
        System.out.println(" is " + b);
    }

    void function1b(int a, int b){
        System.out.print("The least common multiple of " + a + " and " + b);
        int k = a * b / gcd(a,b);
        System.out.println(" is " + k);
    }

    private int gcd(int a, int b){
        if (a == b){
            return a;
        }
        if(a%2 == 0) {
            if(b%2 == 0) {
                return 2*gcd(a/2, b/2);
            } else {
                return gcd(a/2, b);
            }
        } else {
            if (b%2 == 0){
                return gcd(a, b/2);
            }
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            return gcd((max - min)/2, min);
        }
    }

    void function2(int a, int b, int c, int d){
        System.out.print("for " + a + ", " + b + ", " + c + ", " + d);
        int res = gcd(gcd(a,b), gcd(c,d));
        System.out.print(" the greatest common divisor is " + res);
    }

    void function3(int a){
        System.out.println("The area of a regular hexagon is " + 6*a*a*Math.sqrt(3)/4);
    }

    void function4(){
        int[][] dots = new int[][]{{1,2},{3,4},{3,2},{4,1},{5,5},{5,5},{4,2},{2,2}};
        int index1 = 0;
        int index2 = 1;
        double max = distance(dots[index1], dots[index2]);
        for (int i = 0; i < dots.length; i++) {
            for (int j = i; j < dots.length; j++) {
                double k = distance(dots[i], dots[j]);
                if(k > max){
                    max = k;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.printf("The longest distance %.3f%n", max);
        System.out.println("dots (" + dots[index1][0] + ", " + dots[index1][1]
        + ") (" + dots[index2][0] + ", " + dots[index2][1] + ")");
    }

    private double distance(int[] d1, int[] d2){
        return Math.sqrt(Math.pow(d1[0]-d2[0], 2) + Math.pow(d1[1] - d2[1], 2));
    }

    void function5(){
        int[] array1 = new int[]{2,5,1,7,6,3,4,-1,9};
        int max1 = Math.max(array1[0], array1[1]);
        int max2 = Math.min(array1[0], array1[1]);
        for (int i = 2; i < array1.length; i++) {
            if (array1[i] > max1){
                max2 = max1;
                max1 = array1[i];
            } else {
                if(array1[i] > max2);
                max2 = array1[i];
            }
        }
        System.out.println("second max " + max2);
    }

    void function6(int a, int b, int c){
        int n1 = gcd(a, b);
        int n2 = gcd(a, c);
        int n3 = gcd(b, c);
        if (n1+n2+n3 == 3) {
            System.out.println("relatively prime");
        } else {
            System.out.println("not relatively prime");
        }
    }

    void function7a(){
        int res = 0;
        for (int i = 1; i < 10; i += 2) {
            res += factorial(i);
        }
        System.out.println(res);
    }

    private int factorial(int n){
        int k = 1;
        for (int i = 1; i <= n; i++) {
            k *= i;
        }
        return k;
    }

    void function7b(){
        int res = 0;
        int a = 1;
        for (int i = 1; i < 10; i++) {
            a *= i;
            if(i%2 == 1) {
                res += a;
            }
        }
        System.out.println(res);
    }
}
