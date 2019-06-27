package my_game_interface.dataStruct.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int []arr={3,10,2,-1,100,6};
        insertSort(arr);
    }
    public static void insertSort(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            //待插入的元素
            int insertVal=arr[i+1];
            //待插入元素的位置下标
            int insertIndex=i;
            //insertIndex>=0 下标不能为负数
            //insertVal<arr[insertIndex] 待插入元素小于已排好序的元素，则待插入元素需要前移
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
}
