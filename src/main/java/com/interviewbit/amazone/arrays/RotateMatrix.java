package com.interviewbit.amazone.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

    public void rotate(ArrayList<ArrayList<Integer>> matrix) {

        //First revers Diagonal
        reverseDiagonal(matrix);
        //Second reverse from left to right
        reverseFromLeftToRight(matrix);
    }

    private void reverseFromLeftToRight(ArrayList<ArrayList<Integer>> matrix) {
        int size = matrix.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(size - j - 1));
                matrix.get(i).set(size - j - 1, temp);
            }
        }
    }

    private void reverseDiagonal(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = i; j < matrix.size(); j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }
    }

    public static void main(String[] args) {
        /*
        [1, 2],
        [3, 4]
         */
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(row1);
        matrix.add(row2);
        RotateMatrix rotateMatrix = new RotateMatrix();
        System.out.println(matrix);
        rotateMatrix.rotate(matrix);
        System.out.println(matrix);
    }
}
