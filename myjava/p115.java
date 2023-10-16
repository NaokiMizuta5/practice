import java.util.Scanner;

public class p115 {
    public static void main(String[] args) {
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a positive integer: ");
        int n = in.nextInt();
        System.out.printf("Is %d is a palindrome number? \n",n);
        System.out.println(is_Palindrome(n));
    } 

    // 方針としては与えられた数字を逆転し、比較する
    public static boolean is_Palindrome(int n) {
        return (n == reverse_nums(n));
    }
    
    public static int reverse_nums(int n) {
        int reverse = 0;
        while (n != 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }
}
