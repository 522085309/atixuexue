package my_game_interface.dataStruct.sort;

import java.util.Arrays;

public class MaoPao {
    public static void main(String[] args) {
        int []arr={3,10,2,-1,100,6};
        maoPaoSort(arr);
    }
    public static void maoPaoSort(int [] arr){
        //定义变量，标识是否交换过
        boolean flag=false;
        int temp=0;
        //排序的趟数
        for (int i=0;i<arr.length-1;i++){
            //每一趟排序，两两比较，大数会在最后
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
