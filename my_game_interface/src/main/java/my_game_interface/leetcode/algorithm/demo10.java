package my_game_interface.leetcode.algorithm;

public class demo10 {
    public static void main(String[] args) {

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        return merge(lists,0,lists.length - 1);
    }
    public static ListNode merge(ListNode[] arr,int l,int r){
        if (l == r){
            return arr[l];
        }
        int mid = (l + r) >> 1;
        ListNode lNode = merge(arr, l, mid);
        ListNode rNode= merge(arr,mid + 1,r);
        return Demo9.mergeTwoLists(lNode,rNode);
    }
}
