package com.company;

class MyClass3 {

    private int[] array1;
    private int[] array2;

    //print array
    private void printMass(int[] m){
        for (int value : m) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    //replace array elements 'i' and 'j'
    private void swapElements(int[] array, int i, int j){
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }

    //insert one array into another on position 'k'
    void function1(int k){
        array1 = new int[]{1,2,3,4,5,6,7};
        array2 = new int[]{9,8,7,6,5,4};
        printMass(array1);
        printMass(array2);
        System.out.println("k = " + k);
        int[] array3 = new int[array1.length + array2.length];
        for (int i = 0; i < k; i++) {
            array3[i] = array1[i];
        }
        for (int i = k; i < k+array2.length; i++) {
            array3[i] = array2[i-k];
        }
        for (int i = k+array2.length; i < array3.length; i++) {
            array3[i] = array1[k];
            k++;
        }
        printMass(array3);
    }

    //get non-decreasing array from two non-decreasing arrays
    void function2(){
        array1 = new int[]{1,2,7,10};
        printMass(array1);
        array2 = new int[]{2,3,3,8,9,11,12};
        printMass(array2);
        int [] array3 = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index2 < array2.length && index1 < array1.length) {
            while (index2 < array2.length && index1 < array1.length && array1[index1] <= array2[index2]){
                array3[i++] = array1[index1++];
            }
            while (index1 < array1.length && index2 < array2.length && array2[index2] <= array1[index1]){
                array3[i++] = array2[index2++];
            }
        }
        if (index1 < array1.length){
            while (index1 < array1.length){
                array3[i++] = array1[index1++];
            }
        } else {
            while (index2 < array2.length){
                array3[i++] = array2[index2++];
            }
        }
        printMass(array3);
    }

    //selection sort
    void function3(){
        array1 = new int[]{1,2,3,4,4,6,8,9};
        printMass(array1);
        int indexMax;
        int maxElem;
        for (int i = 0; i < array1.length; i++) {
            indexMax = i;
            maxElem = array1[i];
            for (int j = i+1; j < array1.length; j++) {
                if(array1[j] > maxElem){
                    maxElem = array1[j];
                    indexMax = j;
                }
            }
            swapElements(array1, i, indexMax);
        }
        printMass(array1);
    }

    //bubble sort
    void function4(){
        array1 = new int[]{1,2,3,4,4,6,8,9};
        printMass(array1);
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length-1-i; j++) {
                if(array1[j] < array1[j+1]){
                    swapElements(array1, j, j+1);
                    count++;
                }
            }
        }
        printMass(array1);
        System.out.println("count replace " + count);
    }

    //insertion sort with binary search
    void function5(){
        array1 = new int[]{2,5,1,7,6,3,4,8,9};
        printMass(array1);
        int index;
        for (int i = 0; i < array1.length-1; i++) {
            index = binSearch(array1, 0, i, array1[i+1]);
            if(index <= i) {
                int a = array1[i+1];
                for (int j = i+1; j > index; j--) {
                    array1[j] = array1[j-1];
                }
                array1[index] = a;
            }
        }
        printMass(array1);
    }

    //binary search
    private int binSearch(int[] array, int start, int end, int elem){
        int index;
        if (end - start < 2){
            if(elem > array[end]){
                index = end+1;
            } else if (elem < array[start]) {
                index = start;
            } else {
                index = end;
            }
        } else {
            index = (int) (start + Math.ceil((end-start)/2.));
            if(elem > array[index]) {
                index = binSearch(array, index, end, elem);
            } else {
                index = binSearch(array, start, index, elem);
            }
        }
        return index;
    }

    //shell sort
    void function6(){
        array1 = new int[]{2,5,1,7,6,3,4,8,9};
        printMass(array1);
        System.out.println();
        int i = 0;
        while (i < array1.length-1){
            if (array1[i] <= array1[i+1]){
                i++;
            } else {
                swapElements(array1, i, i+1);
                if(i > 0){
                    i--;
                }
            }
        }
        printMass(array1);
    }

    //two non-decreasing arrays, print where insert elements of second
    //array to get final non-decreasing array
    void function7(){
        array1 = new int[]{1,2,7,10};
        array2 = new int[]{2,3,3,8,9,11,12};
        function2();
        int index1 = 0;
        int index2 = 0;
        while (index1 < array1.length && index2 < array2.length){
            if (array2[index2] < array1[index1]){
                System.out.println("number " + array2[index2] + " on " + (index1+index2+1));
                index2++;
            }
            else {
                index1++;
            }
        }
        for (int i = index2; i < array2.length; i++) {
            System.out.println("number " + array2[i] + " on " + (array1.length+i+1));
        }
    }

    //set fractions to common denominator and sort
    void function8(){
        array1 = new int[]{1,2,5,4,3,7,6};
        array2 = new int[]{2,3,4,5,6,7,8};
        printMass(array1);
        System.out.println("- - - - - - -");
        printMass(array2);
        System.out.println("-----------------");
        int n = 1;
        for (int value : array2) {
            n *= value;
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i] * n / array2[i];
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length-1-i; j++) {
                if(array1[j] > array1[j+1]){
                    swapElements(array1, j, j+1);
                    swapElements(array2, j, j+1);
                }
            }
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i] * array2[i] / n;
        }
        printMass(array1);
        printMass(array2);
    }

}
