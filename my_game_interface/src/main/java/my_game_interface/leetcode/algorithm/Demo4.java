package my_game_interface.leetcode.algorithm;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 */
public class Demo4 {
    public static void main(String[] args) {
        int[] nums1 ={1,3};
        int[] nums2 ={2,3,4,8,9,10,11};
//        int[] nums1 ={3,4};
//        int[] nums2 ={1,5,11};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
//
//public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    double num =0.00;
//    int j = 0;
//    int [] arr =new int[nums1.length + nums2.length];
//    for (int i = 0;i < nums1.length;i++){
//        arr[i] = nums1[i];
//    }
//    for (int i = nums1.length;i < nums2.length + nums1.length;i++){
//        arr[i] = nums2[j];
//        j++;
//    }
//    Arrays.sort(arr);
//    int mid = arr.length % 2;
//    //  是奇数
//    if (mid != 0){
//        num  = arr[(arr.length -1) / 2 ] ;
//    }else {
//        num  = ((double) arr[arr.length / 2 ] + (double)arr[arr.length / 2 -1 ]) / 2 ;
//    }
//    return num;
//}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int result[];
        result = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n)
            if(nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            }else{
                result[k++] = nums2[j++];
            }

        while(i < nums1.length)
            result[k++] = nums1[i++];
        while(j < nums2.length)
            result[k++] = nums2[j++];

        if ((m+n)%2 == 0){
            return (result[(m+n)/2-1]+result[(m+n)/2])/2.0;
        }else{
            return result[(m+n)/2];
        }

    }
}
