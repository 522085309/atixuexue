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
        //循环的目的是为了让大于pivot的都放在pivot右边，小于pivot的放在piovt左边
        while (l < r) {
            //如果小于pivot，则移动下标找下一个
            while (arr[l] < pivot) {
                l += l;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>r，则说明已经满足小于pivot的在左边，大于pivot的在右边
            if (l >= r) {
                break;
            }
            //交换位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完，发现arr[l]等于pivot，则r--
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if(l == r){
            l += 1;
            r -= 1;
        }
        //递归左边
        if (left < r){
            quickSort(arr,left,r);
        }
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
