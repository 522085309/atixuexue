package my_game_interface.dataStruct.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int []arr = {3,0,5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int [] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){
                l += l;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] >= pivot){
                r -= 1;
            }
            if (arr[r] <= pivot){
                l += 1;
            }
            while (left < r){
                quickSort(arr,left,r);
            }
            while (right > r){
                quickSort(arr,l,right);
            }
        }
    }
}
