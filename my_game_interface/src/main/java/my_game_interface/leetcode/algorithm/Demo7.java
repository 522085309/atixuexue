package my_game_interface.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class Demo7 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> threeSum = threeSum(nums);
        for (int i = 0 ;i< threeSum.size();i++){
            List<Integer> list = threeSum.get(i);
            for (Integer integer : list){
                System.out.printf("%d\t",integer);
            }
            System.out.println();
        }
    }

    /**
     首先对数组进行排序，排序后固定一个数nums[i]nums[i]，再使用左右指针指向nums[i]nums[i]后面的两端，数字分别为nums[L]nums[L]和nums[R]nums[R]，计算三个数的和sumsum判断是否满足为 00，满足则添加进结果集
     如果nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     如果nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     当sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1]则会导致结果重复，应该跳过，L++L++
     当sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1]则会导致结果重复，应该跳过，R--R−−
     时间复杂度：O(n^2)，n为数组长度
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (nums == null || len < 3 ){
            return null;
        }
        for (int i = 0;i < len ; i++){
            //  排序后，如果第一个数大于0，则后面的数铁定大于0，则和就不可能为0，所以直接break
            if (nums[i] > 0 )
                break;
            //  去重
            if (i > 0 && nums[i] == nums[i -1 ])
                continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //  去重
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    //  去重
                    while (L < R && nums[R] == nums[R - 1])
                        R--;
                    L++;
                    R--;
                }else if (sum > 0) {
                    R--;
                }else if (sum < 0){
                    L++;
                }
            }
        }
        return list;
    }
}
