package my_game_interface.leetcode.algorithm;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 */
public class Demo2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next= new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.next);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp =head;
        //  保留进位
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //  求和
            int sum = x + y + carry;
            //  求模，相当于进位
            carry = sum / 10;
            //  取余，个位数  例子：13 /10 = 1（进位） 13 % 10 = 3(个位)
            sum = sum % 10;
            //  创建节点，让临时指针指向进创建的节点
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            //  如果最后有进位，给进位建立节点
            temp.next = new ListNode(1);
        }
        return head.next;

    }
}

/**
 * 链表元素
 */
  class ListNode {

      int val;

      ListNode next;

      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
