package my_game_interface.dataStruct.serach;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int []arr={0,1,3,3,3,5};
        int mid=binarySerach(arr,0,arr.length-1,3);

        List<Integer> list = binarySearch(arr,0,arr.length-1,3);
        for (Integer integer : list){
            System.out.println(integer);
        }
        System.out.println(mid);
    }

    /**
     *查找某个值的坐标
     * @param arr
     * @param left
     * @param right
     * @param findVal
     */
    public static int  binarySerach(int []arr, int left, int right,int findVal){
        //  说明没找到
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal < mid){
            return binarySerach(arr,left,mid,findVal);
        }else if (findVal > mid){
            return binarySerach(arr,mid+1,right,findVal);
        } else {
            return mid;
        }
    }

    /**
     * 有多个相同的值
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch(int []arr, int left, int right,int findVal){
        //  说明没找到
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal < mid){
            return binarySearch(arr,left,mid,findVal);
        }else if (findVal > mid){
            return binarySearch(arr,mid+1,right,findVal);
        } else {
            List<Integer> indexList = new ArrayList<>();
            //  找到某个值的坐标后，先不返回
            //  从此左边向左查找，如果有符合的值，就将下标加入list
            int temp = mid-1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                indexList.add(temp);
                temp -= 1;
            }
            //  找到的值
            indexList.add(mid);
            //  从此右边向左查找，如果有符合的值，就将下标加入list
            temp = mid + 1;
            while (true){
                if (temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                indexList.add(temp);
                temp += 1;
            }
            return indexList;
        }
    }
}
