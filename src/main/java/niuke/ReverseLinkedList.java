package niuke;

import java.util.Stack;

/**
 * @功能职责: NC78 反转链表
 * 简单  通过率：36.38%  时间限制：1秒  空间限制：64M
 * <p>
 * 描述
 * 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： n\leq1000n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * <p>
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 * 以上转换过程如下图所示：
 * <p>
 * 示例1
 * 输入：
 * {1,2,3}
 * 复制
 * 返回值：
 * {3,2,1}
 * 复制
 * 示例2
 * 输入：
 * {}
 * 复制
 * 返回值：
 * {}
 * 复制
 * 说明：
 * 空链表则输出空
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.data = "0";
        ListNode head = list;
        for (int i = 1; i < 10; i++) {
           ListNode next = new ListNode();
           next.data=String.valueOf(i);
           list.next= next;
           list = next;
        }
        /*list = head;
        while(list.next != null){
            System.out.println(list.data);
            list = list.next;
        }*/
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode listNode = reverseLinkedList.ReverseList(head);
        list = listNode;
        while(list.next !=null){
            System.out.println(list.data);
            list = list.next;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (head.next != null){
            stack.push(head.next);
            head = head.next;
        }
        ListNode headRes = stack.pop();
        ListNode result = headRes;
        while (!stack.isEmpty()){
            ListNode tem = new ListNode();
            ListNode pop = stack.pop();
//            System.out.println(pop.data);
            tem.data = pop.data;
            headRes.next = tem;
            headRes = headRes.next;
        }
        return result;
    }
}
class ListNode{
    String data;
    ListNode next;
}
