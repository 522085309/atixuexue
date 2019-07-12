package my_game_interface.dataStruct.serach;

import java.util.Arrays;

/**
 * kmp算法匹配值
 */
public class Kmp {
    public static void main(String[] args) {
        String src = "BBC ABCDAB ABCDABCDABDE";
        String desc ="ABCDABD";
//        String desc ="ABABACD";
//        String desc ="BB";
        int[] next = kmpNext(desc);
        int i = kmpSearch(src, desc, next);
        System.out.println(i);
    }
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j=0;i < str1.length();i++){
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (str2.length() == j){
                return i - j + 1;
            }
        }
        return -1;
    }
    public static int[] kmpNext(String dest){
        //  创建数组保存部分匹配值
        int []next = new int[dest.length()];
        //  当数组只有一个元素时，部分匹配值为0
        next[0] = 0;
        /**
         *1、如果第一个元素和后面的元素都没用重复的，则部分匹配数组中全为0.
         * 2、如果dest.charAt(i) == dest.charAt(j)，则部分匹配值就+1
         * 3、如果dest.charAt(i) != dest.charAt(j)，重新定位字符串位置。
         */
        for (int i = 1,j=0;i < next.length;i++){
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            //  当dest.charAt(i) == dest.charAt(j)，则部分匹配值就+1；
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
