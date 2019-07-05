package my_game_interface.dataStruct.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {4,6,8,5,9};
        heapSort(arr);
//        adjustSort(arr,arr.length,1);
//        adjustSort(arr,arr.length,0);
    }
    public static void heapSort(int [] arr){
        int temp = 0;
        //  将无序序列调整为堆
        for (int i = arr.length/2 -1 ;i >= 0;i--){
            adjustSort(arr,arr.length,i);
        }
        //  将最大元素与末尾元素进行交互，将最大元素“沉”到数组末端
        //  然后重新调整结构，使其满足堆定义，然后继续交换。
        for (int j = arr.length - 1;j > 0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustSort(arr,j,0);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组构成的二叉树，调整为堆
     * @param arr
     * @param len 标识对多少个元素进行继续调整，len是在逐渐的减少
     * @param i 非叶子节点的下标
     */
    public static  void adjustSort(int []arr ,int len,int i){
        int temp = arr[i];
        //  非叶子节点的左子树开始查找元素，与此叶子节点进行比较
        for (int k = i * 2 +1; k < len;k = k *2 +1){
            //  说明左子节点小于右子节点
            if (k +1 < len && arr[k] < arr[k + 1]){
                //  指向右子节点
                k++;
            }
            //  如果子节点大于此节点的父节点，则交换
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        //  当循环结束，已经将以i为父节点的树的最大值放在顶端了
        arr[i] = temp;
    }
}
