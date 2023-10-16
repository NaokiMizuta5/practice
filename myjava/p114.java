// import java.lang.*;
// import java.util.*;
// import java.io.*;

import java.lang.*;
import java.util.*;
import java.io.*;

public class p114 {
    public static void main(String[] args) {
        String str = "abcdef";
        char[] A = str.toCharArray();
        int offset = 3;
        int len = A.length;
        offset %= len;
        reverse(A, 0, len - offset -1);
        // 0からoffsetの位置までをスワップ
        reverse(A,len-offset,len-1);
        // offsetからlen-1の位置までスワップ
        reverse(A,0,len-1);
        // 全スワップ
        System.out.println("\n" + Arrays.toString(A));
    }

    public static void reverse(char[] str, int start, int end) {
        while (start < end) {
            // startとendをスワップ
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }    
}
