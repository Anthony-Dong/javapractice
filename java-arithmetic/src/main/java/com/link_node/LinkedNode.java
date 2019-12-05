package com.link_node;

/**
 * @date:2019/11/12 12:24
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class LinkedNode {
    private int value;

    public LinkedNode next;

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * 1 -> 2 -> 3 -> null
     * <p>
     * null 1 -> 2 - > 3 -null
     * <p>
     * null <- 1  2 -> 3 -> null
     *
     * @param head
     * @return
     */
    public static LinkedNode reserve(LinkedNode head) {
        LinkedNode prev = null;
        LinkedNode cur = head;
        while (cur != null) {

            LinkedNode temp = cur.next;

            cur.next = prev;

            prev = cur;

            cur = temp;
        }
        return prev;
    }


    public static LinkedNode reserve2(LinkedNode head) {
        if (head == null || head.next == null) {
            System.out.println("===========");
            return head;
        }
        LinkedNode next = head.next;
        LinkedNode newHead = reserve2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4, null))));

        LinkedNode linkedNode = reserve(head);

        System.out.println(linkedNode);
        System.out.println(linkedNode.next);
        System.out.println(linkedNode.next.next);

    }
}
