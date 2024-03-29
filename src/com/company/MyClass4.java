package com.company;

class MyClass4 {

    //find greatest common factor
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

    //find least common multiple
    void function1b(int a, int b){
        System.out.print("The least common multiple of " + a + " and " + b);
        int k = a * b / gcd(a,b);
        System.out.println(" is " + k);
    }

    //greatest common factor
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

    //find greatest common factor for four numbers
    void function2(int a, int b, int c, int d){
        System.out.print("for " + a + ", " + b + ", " + c + ", " + d);
        int res = gcd(gcd(a,b), gcd(c,d));
        System.out.print(" the greatest common divisor is " + res);
    }

    //find the area of regular hexagon with side 'a', using triangle area formula
    void function3(int a){
        double area = 6*equilateralTriangleArea(a);
        System.out.println("The area of a regular hexagon is " + area);
    }

    //triangle area formula
    private double equilateralTriangleArea(int a){
        return a*a*Math.sqrt(3)/4;
    }

    //number of dots 'n', find pair with the longest distance between
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

    //distance between dots
    private double distance(int[] d1, int[] d2){
        return Math.sqrt(Math.pow(d1[0]-d2[0], 2) + Math.pow(d1[1] - d2[1], 2));
    }

    //print second max number
    void function5(){
        int[] array1 = new int[]{2,5,1,7,6,3,4,-1,9};
        int max1 = Math.max(array1[0], array1[1]);
        int max2 = Math.min(array1[0], array1[1]);
        for (int i = 2; i < array1.length; i++) {
            if (array1[i] > max1){
                max2 = max1;
                max1 = array1[i];
            } else {
                if(array1[i] > max2) {
                    max2 = array1[i];
                }
            }
        }
        System.out.println("second max " + max2);
    }

    //find if three numbers are relatively prime
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

    //find sum of factorials of [1,9] odd numbers
    void function7a(){
        int res = 0;
        for (int i = 1; i < 10; i += 2) {
            res += factorial(i);
        }
        System.out.println(res);
    }

    //factorial 'n'
    private int factorial(int n){
        int k = 1;
        for (int i = 1; i <= n; i++) {
            k *= i;
        }
        return k;
    }

    //find sum of factorials of [1,9] odd numbers
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

    //find sum of three consistently positioned elements, inn range [a, b]
    void function8a(int a, int b){
        int[] array1 = new int[]{1,2,3,4,5,6,7,8,9};
        printArray(array1);
        int sum = 0;
        for (int i = a-1; i < b-2; i++) {
            sum = sum + array1[i] + array1[i+1] + array1[i+2];
            System.out.print(sum + " ");
            sum = 0;
        }
        System.out.println();
    }

    //find sum of three consistently positioned elements, inn range [a, b]
    void function8b(int a, int b){
        int[] array1 = new int[]{1,2,3,4,5,6,7,8,9};
        printArray(array1);
        int sum = array1[a-1] + array1[a] + array1[a+1];
        System.out.print(sum + " ");
        for (int i = a; i < b-2; i++) {
            sum = sum - array1[i-1] + array1[i+2];
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    //print array
    private void printArray(int[] arr){
        for (int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    //quadrangle with sides 'x,y,z,t', find area, if right angle between 'x,y'
    void function9(int x, int y, int z, int t){
        double p = (x+y+z+t)/2.;
        double n1 = (p-x)*(p-y)*(p-z)*(p-t);
        double d = Math.sqrt(x*x + y*y);
        double angle1 = Math.acos((z*z+t*t-d*d)/2./z/t);
        double angle2 = Math.toRadians(90.);
        double n2 = x*y*z*t*Math.cos(angle1/2.+angle2/2.);
        double S1 = Math.sqrt(n1-n2);
        System.out.println("Area " + S1);
    }

    //create array consists of digits of number 'n'
    void function10a(int n){
        System.out.println(n);
        int[] mass;
        int count = countN(n);
        mass = new int[count];
        for (int i = count-1; i >= 0; i--) {
            mass[i] = n%10;
            n /= 10;
        }
        printArray(mass);
    }

    //find array size
    private int countN(int n){
        int count = 1;
        while (Math.pow(10, count) <= n){
            count++;
        }
        return count;
    }

    //create array consists of digits of number 'n'
    void function10b(int n){
        System.out.println(n);
        char[] mass = String.valueOf(n).toCharArray();
        for (char c: mass) {
            System.out.print(c + " ");
        }
    }

    //find which number ('a', 'b') has more digits
    void function11(int a, int b){
        int n1 = countN(a);
        int n2 = countN(b);
        if(n1 > n2){
            System.out.println(a + " has more digits than " + b);
        } else if (n2 >n1){
            System.out.println(b + " has more digits than " + a);
        } else {
            System.out.println(a + " and " + b + " has same number of digits");
        }
    }

    //create array, with numbers, sum of digits ='k', number <'n'
    void function12(int k, int n){
        int size = masSize(k, countN(n), n);
        int[] a = new int[size];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            if (countSum(i) == k) {
                a[index++] = i;
            }
        }
        for (int i: a) {
            System.out.print(i + " ");
        }
    }

    //count sum of digits
    private int countSum(int n){
        int sum = 0;
        while (n != 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    //find size of result array
    private int masSize(int k, int len, int max){
        if (len > 1){
            int count = 0;
            int p = (int) Math.pow(10, len-1);
            for (int i = 0; i*p <= max && k-i >= 0; i++) {
                int max3 = Math.min(max - i * p, p - 1);
                count += masSize(k-i, len-1, max3);
            }
            return count;
        } else {
            return k <= max ? 1 : 0;
        }
    }

    //find twin print in range [n, 2*n]
    void function13(int n){
        for (int i = n; i < 2*n-1; i++) {
            if (isPrime(i)){
                if (isPrime(i+2)){
                    System.out.println(i + "," + (i+2) + "; ");
                }
            }
        }
    }

    //check if prime
    private boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    //find all Narcissistic numbers from '1' to 'k'
    void function14(int k){
        for (int i = 1; i < k+1; i++) {
            if(isArm(i)){
                System.out.println(i);
            }
        }
    }

    //check for Narcissistic number
    private boolean isArm(int i){
        int n = countN(i);
        int sum = 0;
        int iCopy = i;
        for (int j = 0; j < n; j++) {
            int k = iCopy%10;
            sum += Math.pow(k, n);
            iCopy /= 10;
        }
        return i == sum;
    }

    //find all 'n'-long numbers, digits of is increasing sequence
    void function15(int k){
        for (int i = (int)Math.pow(10, k-1); i < (int)Math.pow(10, k); i++) {
            if (isUp(i)){
                System.out.print(i + ", ");
            }
        }
    }

    //check for increasing sequence
    private boolean isUp(int i){
        int k1 = i%10;
        i /= 10;
        while (i > 0){
            if (i%10 >= k1){
                return false;
            }
            k1 = i%10;
            i /= 10;
        }
        return true;
    }

    //find sum of 'n'-long numbers, with only odd digits
    //count even digits of sum
    void function16(int k){
        int sum = 0;
        for (int i = (int)Math.pow(10, k-1); i < (int)Math.pow(10, k); i++) {
            if (isOdd(i)){
                sum += i;
            }
        }
        int count = countEven(sum);
        System.out.println("sum " + sum + ", even " + count);
    }

    //check for add digits
    private boolean isOdd(int k){
        while (k > 0){
            if(k%10 == 0) {
                return false;
            }
            k /= 10;
        }
        return true;
    }

    //count even digits
    private int countEven(int k){
        int count = 0;
        while (k > 0){
            if (k%2 == 0){
                count++;
            }
            k /= 10;
        }
        return count;
    }

    //how many times it's possible to subtract from number 'n' sum of its digits till 'n'=0
    void function17(int n){
        int count = 0;
        while (n != 0){
            n -= countDigit(n);
            count++;
        }
        System.out.println("count " + count);
    }

    //count sum of digits
    private int countDigit(int n){
        int sum = 0;
        while (n != 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

}
