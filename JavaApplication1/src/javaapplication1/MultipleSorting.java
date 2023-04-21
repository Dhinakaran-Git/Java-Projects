/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author bas200137
 */
public class MultipleSorting {

    public static void retrivelArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements  
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        retrivelArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[i] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        retrivelArray(arr);
    }

    public static void selectionSort(int[] arr) {
        int temp;
        for (int i = 0; i < 10; i++) {
            int minIndex = arr[i];
            for (int j = 0; j < 10; j++) {
                
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 14, 5, 16, 7, 18, 9};

//        System.out.println("Array Before Bubble Sort");
//        retrivelArray(arr);
//        System.out.println("Array After Bubble Sort");
//        bubbleSort(arr);//sorting array elements using bubble sort
//        System.out.println("Array Before Insertion sort");
//        retrivelArray(arr);
//        System.out.println("Array After Insertion sort");
//        insertionSort(arr);//sorting array elements using insertion sort
        System.out.println("Array Before Selection sort");
        retrivelArray(arr);
        System.out.println("Array After Selection sort");

    }
}
