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
        System.out.println(sll.deleteFirstNode().data);
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


    // deleting first Node of a sll
    public ListNode deleteFirstNode(){
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // deleting last node in a sll
    public ListNode deleteLastNode(){
        if (head==null || head.next==null) {
            return head;
        }
        ListNode current = head;
        ListNode previus = null;
        while (current.next!=null) {
            previus= current;
            current = current.next;
        }
        previus.next = null;
        return current;

    }

    /*
     * Q. Implement method to delete a node at a given position. Assuming position
     * to be valid and starting from 1
     */
    public void deleteNodeInAPosition(int position){
        if (position==1) {
            head = head.next;
        }else{
            ListNode previous = head;
            int count = 0;
            while (count<position-1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    // searching an element in a linked list
    public boolean isValuPresent(int searchKey){
        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // reversing sll
    public ListNode reverseSll(){
        ListNode current = head;
        ListNode previous = null;
        ListNode next= null;
        while (current!= null) {
            next = current.next;
            current.next = previous;
            previous = next;
            current = next;
        }
        return previous;
    }

    // finding the nth node from the end of the linked list
    public ListNode getNthValueFromEnd(int n){
        if (head == null) {
            return null;
        }
        if (n<= 0) {
            throw new IllegalArgumentException("Invalid value of n");
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count<n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n+" is greather than number of nodes in the list");
            }
            refPtr = refPtr.next;
            count++;
            
        }
        while (refPtr!= null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // how to remove duplicates from sorted linked list
}
