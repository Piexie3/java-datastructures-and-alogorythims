package lists;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;


    public static class ListNode{
        int data;
        ListNode previous;
        ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int length(){
        return length;
    }
}
