import java.lang.*;
import java.util.*;
import java.io.*;

public class p88 {
    public static void main(String[] args) {
        int test = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a positive integer: ");
        int n = in.nextInt();

        if(n < 1) {
            System.out.print(Boolean.toString(false));
            test = 1;
        }
        // int どうしの&はビット演算を示し、論理積である
        // nが2のべき乗であった場合 ex) 1000 -1 = 0111
        // 1000 & 0111 = 0000
        if ((n & (n-1)) != 0) {
            System.out.print(Boolean.toString(false));
            test = 1;
        }
        if (test == 0) {
            System.out.print(Boolean.toString((n & 0x55555555) != 0));
        }
        System.out.print("\n");
    }
} 
