package my_game_interface.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Demo3 {
    public static void main(String[] args) {
        int abcbdeb = lengthOfLongestSubstring("pwwkew");
        System.out.println(abcbdeb);
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //  创建map,存放字符和字符的位置
        Map<Character,Integer> map = new HashMap<>();
        //  最大长度
        int max = 0;
        //  开始的索引位置
        int start = 0;
        for (int i = 0;i < s.length();i++){
            //  如果map中存在当前字符
            if (map.containsKey(s.charAt(i))){
                //  比较开始索引和出现此字符的索引，哪个大，就用哪个作为开始索引
                start = Math.max(start,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            //  比较最大的序列长度
            max = Math.max(max,i - start +1);
        }
        return max;
    }
}

