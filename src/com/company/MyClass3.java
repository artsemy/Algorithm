package com.company;

import java.util.Arrays;

class MyClass3 {
    private int[] array1;
    private int[] array2;

    private void printMass(int[] m){
        for (int value : m) {
            System.out.print(value + " ");
        }
    }

    private void swapElements(int[] array, int i, int j){
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }

//    void function1(int k){
//        array1 = new int[]{1,2,3,4,5,6,7};
//        array2 = new int[]{9,8,7,6,5,4};
//        int[] array3 = new int[array1.length + array2.length];
//        for (int i = 0; i < k; i++) {
//            array3[i] = array1[i];
//        }
//        for (int i = k; i < k+array2.length; i++) {
//            array3[i] = array2[i-k];
//        }
//        for (int i = k+array2.length; i < array3.length; i++) {
//            array3[i] = array1[k];
//            k++;
//        }
//        printMass(array3);
//    }

    void function1(int k){
        array1 = new int[]{1,2,3,4,5,6,7,8,9};
        array2 = new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(array1) + Arrays.toString(array2));
        int a;
        for (int i = k; i < array1.length; i++) {
            swapElements(array1, i, i-k);
        }
        for (int i = 0; i < k-(array1.length-array2.length); i++) {
            a = array2[array2.length-1];
            for (int j = array2.length-1; j > 0; j--) {
                array2[j] = array2[j-1];
            }
            array2[0] = a;
        }
        printMass(array1);
        printMass(array2);
    }

    void function2(){
        array1 = new int[]{1,2,9,10};
        array2 = new int[]{2,3,3,8,9,11,12};
        int [] array3 = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index1+index2 < array1.length+array2.length-2) {
            if (array1[index1] < array2[index2]){
                array3[i++] = array1[index1++];
            } else if (array2[index2] < array1[index1]){
                array3[i++] = array2[index2++];
            } else {
                array3[i++] = array1[index1++];
                array3[i++] = array2[index2++];
            }
        }
//        for (int j = index1; j < array1.length; j++) {
//            array3[i++] = array1[j];
//        }
//        for (int j = index2; j < array2.length; j++) {
//            array3[i++] = array2[j];
//        }
        addLastElements(index1, i, array1, array3);
        addLastElements(index2, i, array2, array3);
        printMass(array3);
    }

    private void addLastElements(int index, int i, int[] array, int [] array3){
        for (int j = index; j < array.length; j++, i++) {
            array3[i] = array[j];
        }
    }

    void function3(){
        array1 = new int[]{1,2,3,4,4,6,8,9};
        printMass(array1);
        System.out.println();
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

    void function4(){
        array1 = new int[]{1,2,3,4,4,6,8,9};
        printMass(array1);
        System.out.println();
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

    void function5(){
        array1 = new int[]{2,5,1,7,6,3,4,9,8};
        printMass(array1);
        System.out.println();
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
}
