package com.xiaohua.tixiclass.class06;
/**
 * @author xiaohua
 * @create 2022-05-03 23:13
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val,ListNode next) { this.val = val; this.next = next; }
}
public class leetcode78 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length<1){
            return null;
        }
        if(lists.length<2){
            return lists[0];
        }
        int mergesize = 1;
        while (mergesize<lists.length){

            int left = 0;
            while (left<lists.length){

                int right = left+mergesize;
                if (right>=lists.length){
                    break;
                }
                lists[left] = mergelist(lists[left],lists[right]);
                left=right+1;
            }


            if (mergesize>lists.length/2){
                break;
            }
            mergesize<<=1;

        }

        return lists[0];
    }

    private ListNode mergelist(ListNode head1, ListNode head2) {
        ListNode myhead = new ListNode();
        ListNode rear = myhead;
        ListNode p = head1;
        ListNode q = head2;
        while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                p = head1.next;
                head1.next = rear.next;
                rear.next = head1;
                rear = head1;
                head1 = p;
            }else {
                q = head2.next;
                head2.next = rear.next;
                rear.next = head2;
                rear = head2;
                head2 = q;
            }
        }
        if (head1!=null){
            rear.next = head1;
        }else {
            rear.next = head2;
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1, new ListNode(3, new ListNode(4,new ListNode(6,new ListNode(8,new ListNode(9,new ListNode(12)))))));
        listNodes[1] = new ListNode(1, new ListNode(2, new ListNode(5,new ListNode(7,new ListNode(11,new ListNode(21,new ListNode(24)))))));
        listNodes[2] = new ListNode(2, new ListNode(-4,new ListNode(0,new ListNode(4,new ListNode(7,new ListNode(10,new ListNode(14,new ListNode(22,new ListNode(24)))))))));

        leetcode78 leetcode78 = new leetcode78();
        ListNode listNode = leetcode78.mergeKLists(listNodes);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
