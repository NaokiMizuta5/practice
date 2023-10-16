import java.util.Scanner;

public class p118 {
    public static void main(String[] args) {
        String s = "Python";
        String t = "th";
        System.out.printf(String.valueOf(strStr(s,t)));
    }
    public static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        // targetがブランクもしくはtargetがsourceに等しい時 
        if ("".equals(target) || source.equals(target)) {
            return 0;
        }
        int i = 0;
        // lastはsourceの最後の位置
        int last = source.length() - target.length() + 1;
        while (i < last) {
            if(source.charAt(i) == target.charAt(0)) {
                boolean equal = true;
                // targetと一文字づつ比較
                // 途中で途切れたらsourceのカーソルを移動
                for (int j = 0; j < target.length() && equal; ++j) {
                    // for文のインクリメントの前置後置はあんま関係ない
                    if(source.charAt(i + j) != target.charAt(j)) {
                        equal = false;
                    }
                }
                if (equal) {
                    return i;
                }
            }
            ++i;
        }
        // returnの罠に引っかからんかったら-1を返す
        return -1;
    }
}
