package com.interviewbit.amazone.math;

public class ExcelColumnNumber {
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for(char ch : columnTitle.toCharArray()){

            columnNumber *= 26;
            columnNumber += (ch- 'A' )+1;
        }
        return columnNumber;
    }
}
