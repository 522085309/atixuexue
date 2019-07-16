package my_game_interface.leetcode.algorithm;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 */
public class Demo8 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode head = removeNthFromEnd(listNode, 2);
        System.out.println(head.val);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        ListNode temp =new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        int j = size(head) - n;
        while (j > 0){
            j -- ;
            first = first.next;
        }
        first.next = first.next.next;
        return temp.next;
    }
    public static int size(ListNode head){
        if (head == null){
            return -1;
        }
        ListNode temp = head;
        int i = 0;
        while (temp != null){
            i++;
            temp = temp.next;
        }
        return i;
    }
}

//class ListNode {
//
//    int val;
//
//    ListNode next;
//
//    ListNode(int x) { val = x; }
//
//}
