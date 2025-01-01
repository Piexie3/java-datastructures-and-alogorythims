package lists;

public class SinglyLinkedList {
    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(11);

        // connecting nodes
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.printLinkedList();
        int count = sll.sllLnength();
        System.out.println("Sll length is: " + count);
        sll.insertNodeAtHead(4);
        sll.printLinkedList();
        sll.insertAtTheEnd(7);
        sll.printLinkedList();
        sll.insert(4, 10);
        sll.insert(7, 6);
        sll.insert(1, 5);
        sll.printLinkedList();
    }

    // singly linked list
    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printLinkedList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "--> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    // finding lenth of a singly linked list
    public int sllLnength() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // inserting nodes in a singly linked list
    public void insertNodeAtHead(int value) {
        ListNode newListNode = new ListNode(value);

        newListNode.next = head;
        head = newListNode;

    }
    //inserting at the end of the sll
    public void insertAtTheEnd(int value){
        ListNode newListNode = new ListNode(value);
        if (head==null) {
            head = newListNode;
            return;
        }
        ListNode currentNode = head;
        while (null!= currentNode.next) {
            currentNode = currentNode.next;
        }
        currentNode.next = newListNode;
    }

    // inserting at a given position
    /*
     * Q. implement method to insert a node at a given position. Assuming to be valid and starting from 1.
     */
    public void insert(int position, int value){
        ListNode node = new ListNode(value);
        if (position == 1) {
            node.next = head;
            head = node;
        }else{
            ListNode previous = head;
            int count = 1;
            while (count<position-1) {
                previous = previous.next;
                count++;
            }
            ListNode currentListNode =previous.next;
            previous.next = node;
            node.next = currentListNode;
        }
    }
}
