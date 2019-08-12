package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MyClass2 {

    private int[][] matrixInt;
    private double[][] matrixDouble;

    private void initMatrix(int xSize, int ySize, int minElem, int maxElem){
        matrixInt = new int[xSize][ySize];
        Random random = new Random();
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                matrixInt[i][j] = random.nextInt(maxElem+1) + minElem;
            }
        }
    }

    private void initDefaultMatrix(){
        int xSize = 5;
        int ySize = 5;
        int minElem = -10;
        int maxElem = 10 - minElem;
        initMatrix(xSize, ySize, minElem, maxElem);
    }

    private void printIntMatrix(){
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                System.out.printf("%4d", matrixInt[i][j]);
            }
            System.out.println();
        }
        if(matrixInt.length == 0){
            System.out.println("empty matrix");
        }
        System.out.println("----------------------");
    }

    private void printDoubleMatrix(){
        for (int i = 0; i < matrixDouble.length; i++) {
            for (int j = 0; j < matrixDouble[0].length; j++) {
                System.out.printf("%7.2f", matrixDouble[i][j]);
            }
            System.out.println();
        }
        if(matrixDouble.length == 0){
            System.out.println("empty matrix");
        }
        System.out.println("----------------------");
    }

    void function1(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt[0].length; i += 2) {
            if(matrixInt[0][i] > matrixInt[matrixInt.length-1][i]){
                printColumn(i);
            }
        }
    }

    private void printColumn(int j){
        for (int i = 0; i < matrixInt.length; i++) {
            System.out.printf("%4d", matrixInt[i][j]);
        }
        System.out.println();
    }

    private void printLine(int i){
        for (int j = 0; j < matrixInt[0].length; j++) {
            System.out.printf("%4d", matrixInt[i][j]);
        }
        System.out.println();
    }

    void function2(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            System.out.print(matrixInt[i][i] + " ");
        }
    }

    void function3(){
        initDefaultMatrix();
        printIntMatrix();
        int kLine = 3;
        int pColumn = 4;
        printLine(kLine - 1);
        printColumn(pColumn - 1);
    }

    void function4(){
        int n = 6;
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

    void function5(){
        int n = 6;
        matrixInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                matrixInt[i][j] = i + 1;
            }
        }
        printIntMatrix();
    }

    void function6(){
        int n = 4;
        matrixInt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                matrixInt[i][j] = 1;
                matrixInt[n-i-1][j] = 1;
            }
        }
        printIntMatrix();
    }

    void function7(){
        int n = 5;
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

    void function8(){
        initDefaultMatrix();
        printIntMatrix();
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert number1: ");
        int column1 = scanner.nextInt();
        System.out.println("insert number2: ");
        int column2 = scanner.nextInt();
        for (int i = 0; i < matrixInt.length; i++) {
            int elem = matrixInt[i][column1-1];
            matrixInt[i][column1-1] = matrixInt[i][column2-1];
            matrixInt[i][column2-1] = elem;
        }
        printIntMatrix();
        scanner.close();
    }

    void function9(){
        initDefaultMatrix();
        printIntMatrix();
        int max = -1;
        int sum;
        int number = -1;
        for (int j = 0; j < matrixInt[0].length; j++) {
            sum = 0;
            for (int i = 0; i < matrixInt.length; i++) {
                sum += matrixInt[i][j];
            }
            System.out.print("  " + sum);
            if(sum > max){
                max = sum;
                number = j;
            }
        }
        System.out.println("\ncolumn " + (number+1));
    }

    void function10(){
        initDefaultMatrix();
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            if(matrixInt[i][i] > 0){
                System.out.print("  " + matrixInt[i][i]);
            }
        }
    }

    void function11(){
        initDefaultMatrix();
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

    void function12(){
        initDefaultMatrix();
        superFunction(false);
    }

    private void superFunction(boolean b){
        printIntMatrix();
        if(b){ transpose(); }
        for (int[] ints : matrixInt) {
            Arrays.sort(ints);
        }
        if(b){ transpose(); }
        printIntMatrix();
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                matrixInt[i][j] *= -1;
            }
        }
        if(b){ transpose(); }
        for (int[] ints : matrixInt) {
            Arrays.sort(ints);
        }
        if(b){ transpose(); }
        for (int i = 0; i < matrixInt.length; i++) {
            for (int j = 0; j < matrixInt[0].length; j++) {
                matrixInt[i][j] *= -1;
            }
        }
        printIntMatrix();
    }

    private void transpose(){
        int[][] mass2 = new int[matrixInt.length][matrixInt[0].length];
        for(int i = 0; i < mass2.length; ++i){
            for(int j = 0; j < mass2[0].length; j++){
                mass2[i][j] = matrixInt[j][i];
            }
        }
        matrixInt = mass2;
    }

    void function13(){
        initDefaultMatrix();
        superFunction(true);
    }

    void function14(){
        int m = 7;
        int n = 5;
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

    void function15(){
        initDefaultMatrix();
        printIntMatrix();
        int max = findMaxElement();
        for(int i = 0; i < matrixInt.length; i++){
            for(int j = 0; j < matrixInt[0].length; j++){
                if((i+j)%2 == 0) {
                    matrixInt[i][j] = max;
                }
            }
        }
        printIntMatrix();
    }

    private int findMaxElement(){
        int max = matrixInt[0][0];
        for(int i = 0; i < matrixInt.length; i++){
            for(int j = 0; j < matrixInt[0].length; j++){
                if(matrixInt[i][j] > max){
                    max = matrixInt[i][j];
                }
            }
        }
        return max;
    }

    void function16(){
        int n = 3;
        int sum = (1+n*n)*n/2;
        
    }
}
