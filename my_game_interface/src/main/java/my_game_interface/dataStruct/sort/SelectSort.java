package my_game_interface.dataStruct.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={5,1,6,100,0,-3,10};
        selectSort(arr);
    }
    public static void selectSort(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            //假设最小的元素为下标为i
            int minIndex=i;
            //假设最小的元素值
            int min=arr[i];
            for (int j=i+1;j<arr.length;j++){
                //如果假设的最小元素大于某个值，则重新定位最小元素的坐标
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            //此时已经定位到最小的元素和最小元素的下标，现在将假设的最小元素与真正的最小元素进行交换
            if (minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
