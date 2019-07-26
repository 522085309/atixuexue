package my_game_interface.leetcode.algorithm;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 */
public class Demo12 {
    public static void main(String[] args) {
        String [] strs = { "flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        return merge(strs,0,strs.length - 1);
    }

    public static String merge(String[] str,int left,int right){
        if (left == right){
            return str[left];
        }else {
            int mid = (left + right) >> 1;
            String mergeLeft = merge(str, left, mid);
            String mergeRight = merge(str, mid + 1, right);
            return mergrStr(mergeLeft, mergeRight);
        }
    }

    public static String mergrStr(String s1,String s2){
        for (int i = 0;i < Math.min(s1.length(),s2.length());i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.substring(0,Math.min(s1.length(),s2.length()));
    }

    /**
     *水平扫描法
     */
/*    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }*/
}
