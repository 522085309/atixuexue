package my_game_interface.dataStruct.sort;

/**
 * 归并排序(分治思想)
 */
public class MergetSort {
    public static void main(String[] args) {
        int [] arr ={4,1,5,0};
        int []temp = new int[arr.length];
        mergetSort(arr,0,arr.length-1,temp);
    }

    /**
     *先分解数组
     * @param arr 传入的待排序数组
     * @param left 排序数组的左下标
     * @param right 排序数组的右下标
     * @param temp 临时数组
     */
    public static void mergetSort(int []arr,int left,int right,int [] temp){
        if (left < right){
            //  中间索引
            int mid=(left + right)/2;
            //  向左递归分解
            mergetSort(arr,left,mid,temp);
            //  向右递归分解
            mergetSort(arr,mid+1,right,temp);
            //  归并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int []arr ,int left,int mid,int right,int [] temp){
        //初始化i，左边有序序列的初始化索引
        int i = left;
        //  初始化j，右边有序序列的初始化索引
        int j = mid + 1;
        //  临时数组的下标
        int t = 0;

        //  一、先把左右两边有序的数据存入临时数组中，直到有一边的数据处理完
        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                i += 1;
                t += 1;
            }else {
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }
        //  二、把剩余一边的数据按顺序填充到临时数组中
        while (i <= mid){
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }
        while (j <= right){
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }
        // 三、将temp的元素拷贝到arr 注意：不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }


}
