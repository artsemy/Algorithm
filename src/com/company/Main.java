package com.company;

public class Main {

    public static void main(String[] args) {
        //one-dimensional array
//        part1();
        //matrix (array of arrays)
//        part2();
        //sorting
//        part3();
        //decomposition
//        part4();
    }

    private static void part1(){
        MyClass myClass = new MyClass();
        //find sum of elements (only that multiple to 'k') from mass
        myClass.function1(3);
        //replace element that more than 'Z' with 'Z' from array
        //count replaces
        myClass.function2(10);
        //count positive, negative and zero elements from double array
        myClass.function3();
        //replace min and max elements in double array
        myClass.function4();
        //print elements that more than their index in integer array
        myClass.function5();
        //count sum of elements with prime number indexes, double array
        myClass.function6();
        //find max sum of center symmetric elements of double array
        myClass.function7();
        //create new array from another array without its min elements
        myClass.function8();
        //find mostly repeated number in array
        //print minimal of them if there two or more founded
        myClass.function9(10);
        //squeeze array - delete every second element, free places set '0'
        myClass.function10(4);
    }

    private static void part2(){
        MyClass2 myClass2 = new MyClass2();
        //print odd columns where first element more than last
        //count from '1'
        myClass2.function1();
        //print diagonal elements
        myClass2.function2();
        //print 'k' line and 'p' column; count from '1'
        myClass2.function3(3, 4);
        //form matrix with lines [1 ... n] and [n ... 1]; n even
        myClass2.function4(6);
        //form matrix [1 1 ... 1 1] [2 2 ... 2 0] [3 3 ... 0 0] ... [n 0 ... 0 0]; n even
        myClass2.function5(6);
        //form matrix [1 1 ... 1 1] [0 1 ... 1 0] ... [0 1 ... 1 0] [1 1 ... 1 1]; n even
        myClass2.function6(6);
        //form matrix 'n' a[i, j] = sin((i^2-j^2)/n); count positive elements
        myClass2.function7(5);
        //replace two columns, numbers inserted; count from 1
        myClass2.function8();
        //count column sum, find max sum
        myClass2.function9();
        //find positive elements of main diagonal
        myClass2.function10();
        //matrix 10x20, print matrix and line number, where more than three elements-'5'
        myClass2.function11();
        //sort line, increase and decrease elements
        myClass2.function12();
        //sort columns, increase and decrease elements
        myClass2.function13();
        //form m*n [0,1] matrix, 'n'-column has n-'1'
        myClass2.function14(5, 5);
        //find max elem, replace all odd elements with max
        myClass2.function15();
        //form magic square
        myClass2.function16(3);
    }

    private static void part3(){
        MyClass3 myClass3 = new MyClass3();
        //insert one array into another on position 'k'
        myClass3.function1(4);
        //get non-decreasing array from two non-decreasing arrays
        myClass3.function2();
        //selection sort
        myClass3.function3();
        //bubble sort
        myClass3.function4();
        //insertion sort with binary search
        myClass3.function5();
        //shell sort
        myClass3.function6();
        //two non-decreasing arrays, print where insert elements of second
        //array to get final non-decreasing array
        myClass3.function7();
        //set fractions to common denominator and sort
        myClass3.function8();
    }

    private static void part4(){
        MyClass4 myClass4 = new MyClass4();
        //find greatest common factor and least common multiple
        myClass4.function1a(10, 15);
        myClass4.function1b(27,18);
        //find greatest common factor for four numbers
        myClass4.function2(32,4,8,16);
        //find the area of regular hexagon with side 'a', using triangle area formula
        myClass4.function3(2);
        //number of dots 'n', find pair with the longest distance between
        myClass4.function4();
        //print second max number
        myClass4.function5();
        //find if three numbers are relatively prime
        myClass4.function6(6,3,5);
        //find sum of factorials of [1,9] odd numbers
        myClass4.function7a();
        myClass4.function7b();
        //find sum of three consistently positioned elements, inn range [a, b]
        myClass4.function8a(2,8);
        myClass4.function8b(2,8);
        //quadrangle with sides 'x,y,z,t', find area, if right angle between 'x,y'
        myClass4.function9(3,4,3,4);
        //create array consists of digits of number 'n'
        myClass4.function10a(123433659);
        myClass4.function10b(123433659);
        //find which number ('a', 'b') has more digits
        myClass4.function11(10,9);
        //create array, with numbers, sum of digits ='k', number <'n'
        myClass4.function12(15, 439);
        //find twin print in range [n, 2*n]
        myClass4.function13(100);
        //find all Narcissistic numbers from '1' to 'k'
        myClass4.function14(1000);
        //find all 'n'-long numbers, digits of is increasing sequence
        myClass4.function15(2);
        //find sum of 'n'-long numbers, with only odd digits
        //count even digits of sum
        myClass4.function16(4);
        //how many times it's possible to subtract from number 'n' sum of its digits till 'n'=0
        myClass4.function17(119);
    }
}
