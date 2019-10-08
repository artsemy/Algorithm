package com.company;

import java.util.Random;
import java.util.Scanner;

class MyClass2 {

    private int[][] matrixInt;
    private double[][] matrixDouble;

    //init matrix with params
    private void initMatrix(int xSize, int ySize, int minElem, int maxElem){
        matrixInt = new int[xSize][ySize];
        Random random = new Random();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                matrixInt[i][j] = random.nextInt(maxElem+1) + minElem;
            }
        }
    }

    //init matrix with default params
    private void initDefaultMatrix(){
        int xSize = 5;
        int ySize = 5;
        int minElem = -10;
        int maxElem = 10 - minElem;
        initMatrix(xSize, ySize, minElem, maxElem);
    }

    //print matrix
    private void printIntMatrix(){
        for (int[] ints : matrixInt) {
            for (int j : ints) {
                System.out.printf("%4d", j);
            }
            System.out.println();
        }
        if(matrixInt.length == 0){
            System.out.println("empty matrix");
        }
        System.out.println("----------------------");
    }

    //print matrix
    private void printDoubleMatrix(){
        for (double[] doubles : matrixDouble) {
            for (double j : doubles) {
                System.out.printf("%7.2f", j);
            }
            System.out.println();
        }
        if(matrixDouble.length == 0){
            System.out.println("empty matrix");
        }
        System.out.println("----------------------");
    }

    //print odd columns where first element more than last
    //count from '1'
    void function1(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt[0].length; i += 2) {
            if(matrixInt[0][i] > matrixInt[matrixInt.length-1][i]){
                printColumn(i);
            }
        }
    }

    //print column 'j'
    private void printColumn(int j){
        for (int[] ints : matrixInt) {
            System.out.printf("%4d", ints[j]);
        }
        System.out.println();
    }

    //print line 'i'
    private void printLine(int i){
        for (int j = 0; j < matrixInt[0].length; j++) {
            System.out.printf("%4d", matrixInt[i][j]);
        }
        System.out.println();
    }

    //print diagonal elements
    void function2(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            System.out.printf("%4d", matrixInt[i][i]);
        }
        System.out.println();
    }

    //print 'k' line and 'p' column; count from '1'
    void function3(int k, int p){
        initDefaultMatrix();
        printIntMatrix();
        printLine(k - 1);
        printColumn(p - 1);
    }

    //form matrix with lines [1 ... n] and [n ... 1]; n even
    void function4(int n){
        matrixInt = new int[n][n];
        int[] line1 = new int[n];
        int[] line2 = new int[n];
        for (int i = 0; i < n; i++) {
            line1[i] = i + 1;
            line2[i] = n - i;
        }
        for (int i = 0; i < n; i += 2) {
            matrixInt[i] = line1;
            matrixInt[i+1] = line2;
        }
        printIntMatrix();
    }

    //form matrix [1 1 ... 1 1] [2 2 ... 2 0] [3 3 ... 0 0] ... [n 0 ... 0 0]; n even
    void function5(int n){
        matrixInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                matrixInt[i][j] = i + 1;
            }
        }
        printIntMatrix();
    }

    //form matrix [1 1 ... 1 1] [0 1 ... 1 0] ... [0 1 ... 1 0] [1 1 ... 1 1]; n even
    void function6(int n){
        matrixInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                matrixInt[i][j] = 1;
                matrixInt[n-i-1][j] = 1;
            }
        }
        printIntMatrix();
    }

    //form matrix 'n' a[i, j] = sin((i^2-j^2)/n); count positive elements
    void function7(int n){
        int count = 0;
        matrixDouble = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixDouble[i][j] = Math.sin((double)(i*i-j*j)/n);
                if(matrixDouble[i][j] > 0){
                    count++;
                }
            }
        }
        printDoubleMatrix();
        System.out.println("poz: " + count);
    }

    //replace two columns, numbers inserted; count from 1
    void function8(){
        initDefaultMatrix();
        printIntMatrix();
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert number1, [1,5]: ");
        int column1 = scanner.nextInt();
        System.out.println("insert number2, [1,5]: ");
        int column2 = scanner.nextInt();
        for (int i = 0; i < matrixInt.length; i++) {
            int elem = matrixInt[i][column1-1];
            matrixInt[i][column1-1] = matrixInt[i][column2-1];
            matrixInt[i][column2-1] = elem;
        }
        printIntMatrix();
//        scanner.close();
    }

    //count column sum, find max sum
    void function9(){
        initMatrix(5, 5, 0, 9);
        printIntMatrix();
        int max = -1;
        int sum;
        int number = -1;
        for (int j = 0; j < matrixInt[0].length; j++) {
            sum = 0;
            for (int[] ints : matrixInt) {
                sum += ints[j];
            }
            System.out.printf("%4d", sum);
            if(sum > max){
                max = sum;
                number = j;
            }
        }
        System.out.println("\ncolumn " + (number+1));
    }

    //find positive elements of main diagonal
    void function10(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            if(matrixInt[i][i] > 0){
                System.out.printf("%4d", matrixInt[i][i]);
            }
        }
    }

    //matrix 10x20, print matrix and line number, where more than three elements-'5'
    void function11(){
        initMatrix(10, 20, 0, 15);
        printIntMatrix();
        int five = 5;
        int count;
        for (int i = 0; i < matrixInt.length; i++) {
            count = 0;
            for (int j = 0; j < matrixInt[0].length; j++) {
                if(matrixInt[i][j] == five){
                    count++;
                }
            }
            if(count > 2){
                System.out.print("  " + (i+1));
            }
        }
    }

    //sort line, increase and decrease elements
    void function12(){
        initDefaultMatrix();
        superFunction(false);
    }

    //sort and print elements, b-false in lines, b-true in columns
    private void superFunction(boolean b){
        printIntMatrix();
        if(b){ transpose(); }
        for (int i = 0; i < matrixInt.length; ++i) {
            matrixInt[i] = sort(matrixInt[i]);
        }
        if(b){ transpose(); }
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                matrixInt[i][j] *= -1;
            }
        }
        if(b){ transpose(); }
        for (int i = 0; i < matrixInt.length; ++i) {
            matrixInt[i] = sort(matrixInt[i]);
        }
        if(b){ transpose(); }
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                matrixInt[i][j] *= -1;
            }
        }
        printIntMatrix();
    }

    //sort increase
    private int[] sort(int[] ints){
        for (int i = 0; i < ints.length; i++) {
            for (int j = i+1; j < ints.length; j++) {
                if (ints[i] > ints[j]){
                    int k = ints[i];
                    ints[i] = ints[j];
                    ints[j] = k;
                }
            }
        }
        return ints;
    }

    //transpose matrix
    private void transpose(){
        int[][] mass2 = new int[matrixInt.length][matrixInt[0].length];
        for(int i = 0; i < mass2.length; ++i){
            for(int j = 0; j < mass2[0].length; j++){
                mass2[i][j] = matrixInt[j][i];
            }
        }
        matrixInt = mass2;
    }

    //sort columns, increase and decrease elements
    void function13(){
        initDefaultMatrix();
        superFunction(true);
    }

    //form m*n [0,1] matrix, 'n'-column has n-'1'
    void function14(int m, int n){
        matrixInt = new int[m][n];
        Random r = new Random();
        for (int i = 0; i < n; i++){
            int count = i+1;
            while(count > 0){
                int k = r.nextInt(m);
                if(matrixInt[k][i] != 1){
                    matrixInt[k][i] = 1;
                    count--;
                }
            }
        }
        printIntMatrix();
    }

    //find max elem, replace all odd elements with max
    void function15(){
        initDefaultMatrix();
        printIntMatrix();
        int max = findMaxElement();
        for(int i = 0; i < matrixInt.length; i++){
            for(int j = 0; j < matrixInt[0].length; j++){
                if(matrixInt[i][j]%2 != 0) {
                    matrixInt[i][j] = max;
                }
            }
        }
        printIntMatrix();
    }

    //find max element in matrix
    private int findMaxElement(){
        int max = matrixInt[0][0];
        for (int[] ints : matrixInt) {
            for (int i : ints) {
                if (i > max) {
                    max = i;
                }
            }
        }
        return max;
    }

    //form magic square
    void function16(int n){
        int sum = (1+n*n)*n/2;
        matrixInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixInt[i][j] = i + j + (n-1)*i + 1;
            }
        }
        printIntMatrix();
        while (!checkMagick(sum)){
            replace(n);
        }
        printIntMatrix();
    }

    //replace elements
    private void replace(int n){
        Random r = new Random();
        int x1 = r.nextInt(n);
        int y1 = r.nextInt(n);
        int x2 = r.nextInt(n);
        int y2 = r.nextInt(n);
        int k = matrixInt[x1][y1];
        matrixInt[x1][y1] = matrixInt[x2][y2];
        matrixInt[x2][y2] = k;
    }

    //check for magic
    private boolean checkMagick(int l){
        for (int i = 0; i < matrixInt[0].length; i++) {
            int sum = 0;
            for (int[] ints : matrixInt) {
                sum += ints[i];
            }
            if (sum != l){
                return false;
            }
        }
        for (int[] ints: matrixInt) {
            int sum = 0;
            for (int j: ints) {
                sum += j;
            }
            if (sum != l){
                return false;
            }
        }
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < matrixInt.length; i++) {
            s1 += matrixInt[i][i];
            s2 += matrixInt[i][matrixInt.length-1-i];
        }
        return s1 == l && s2 == l;
    }

}
