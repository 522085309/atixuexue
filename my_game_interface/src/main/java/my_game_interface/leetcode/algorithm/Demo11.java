package my_game_interface.leetcode.algorithm;

/**
 * 盛水容器
 */
public class Demo11 {
    public static void main(String[] args) {
        int []arr = {1,3,5,7,9};
        System.out.println(maxArea(arr));
    }
    //    public static int maxArea(int[] height) {
//        int maxarea = 0;
//        for (int i = 0; i < height.length; i++)
//            for (int j = i + 1; j < height.length; j++)
//                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
//        return maxarea;
//    }
    public static int maxArea(int[] arr) {
        int max = 0;
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        while (l < r){
            max = Math.max(max,Math.min(arr[l],arr[l]) * (r - l));
            if (arr[l] < arr[r]){
                l ++;
            }else {
                r --;
            }
        }
        return  max;
    }

}
