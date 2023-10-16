import java.util.*;

public class p129 {
    public static void main(String[] args) {
        int nums[] = {10, 10, 20, 30, 40, 40, 30, 50};
        int result;
        System.out.println("Source Array : " + Arrays.toString(nums));
        result = getSingleNumber(nums);
        System.out.println("\n"+result+"appears only once");
    }
    public static int getSingleNumber(int[] nums) {
        if(nums == null) {
            return -1;
        }
        int result = 0;
        for(int i = 0;i < nums.length; i++) {
            // resultとnums[i]との排他的論理和
            // 数値と0だったら数値が残る
            // 同じ数値だったらキャンセルされる
            // しかし、この場合奇数回全てに対して適応される
            result ^= nums[i];
        }
        return result;
    }
}
