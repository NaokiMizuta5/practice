import java.util.*;
import java.lang.*;

public class p128 {
    public static void main(String[] args) {
        int[] nums = {10,2,38,22,38,23};
        System.out.println("Original array: "+Arrays.toString(nums));
        System.out.println("Median of the said array of integers: " + getMedian(nums));
        int[] nums1 = {10,2,38,23,38,23,21};
        System.out.println("Original array: "+Arrays.toString(nums1));
        System.out.println("Median of the said array of integers: " + getMedian(nums1));  
    }
    public static int getMedian(int[] array) {
        // 配列の長さが偶数だった場合
        if (array.length % 2 == 0) {
            // midは真ん中の右 ∵index0スタート
            int mid = array.length /2;
            return (array[mid] + array[mid -1]) /2;
        }
        return array[array.length / 2];
        // 例えば{0,1,2,3,4}
        // だったらlength == 5
        // 5 /2 = 2 →　真ん中
    }
}
