/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author bas200137
 */
public class MultiArrays {

    public static void main(String[] args) {
        int[][] arr = {
            {100, 20, 15, 24, 10, 45},
            {10, 26, 54, 25, 30, 75}
        };
        int find = 100;
        int count = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                count++;
                if (find == arr[i][j]) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println(find + " exists " + found);
        System.out.println(count);
    }
}
