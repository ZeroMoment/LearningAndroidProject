package cn.lzm.prac.learn.arithmetic;

public class Node {

    //数据域
    public Integer data;
    //指针域 指向下个节点
    public Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node reverseList(Node head) {

        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
    

}
