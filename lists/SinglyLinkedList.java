package lists;

public class SinglyLinkedList {
    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtTheEnd(2);
        sll.insertAtTheEnd(2);
        sll.insertAtTheEnd(5);
        sll.insertAtTheEnd(7);
        sll.insertAtTheEnd(9);
        sll.insertAtTheEnd(9);

        sll.removeSortedDuplicate();
        sll.printLinkedList();
        sll.addInASortedList(8);
        sll.printLinkedList();
        sll.removeAValueInAListNode(5);
        sll.printLinkedList();
        System.out.println(sll.detectLoop(sll.head));
        System.out.println(sll.detectLoop(sll.createALoopList()));
        sll.removeLoopByPointingLastNodeToNull();
        sll.printLinkedList();
        System.out.println(sll.detectLoop(sll.head));
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

    // inserting at the end of the sll
    public void insertAtTheEnd(int value) {
        ListNode newListNode = new ListNode(value);
        if (head == null) {
            head = newListNode;
            return;
        }
        ListNode currentNode = head;
        while (null != currentNode.next) {
            currentNode = currentNode.next;
        }
        currentNode.next = newListNode;
    }

    // inserting at a given position
    /*
     * Q. implement method to insert a node at a given position. Assuming to be
     * valid and starting from 1.
     */
    public void insert(int position, int value) {
        ListNode node = new ListNode(value);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode currentListNode = previous.next;
            previous.next = node;
            node.next = currentListNode;
        }
    }

    // deleting first Node of a sll
    public ListNode deleteFirstNode() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // deleting last node in a sll
    public ListNode deleteLastNode() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previus = null;
        while (current.next != null) {
            previus = current;
            current = current.next;
        }
        previus.next = null;
        return current;

    }

    /*
     * Q. Implement method to delete a node at a given position. Assuming position
     * to be valid and starting from 1
     */
    public void deleteNodeInAPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 0;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    // searching an element in a linked list
    public boolean isValuPresent(int searchKey) {
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
    public ListNode reverseSll() {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = next;
            current = next;
        }
        return previous;
    }

    // finding the nth node from the end of the linked list
    public ListNode getNthValueFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value of n");
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greather than number of nodes in the list");
            }
            refPtr = refPtr.next;
            count++;

        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // how to remove duplicates from sorted linked list
    /*
     * Example
     * head = 1 --> 1 --> 2 --> 4 --> 8 --> 8 --> 9
     * output = 1 --> 2 --> 4 --> 8 --> 9
     */
    public void removeSortedDuplicate() {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

    }

    // adding a node in a sorded list
    /*
     * Example
     * head = 1 --> 1 --> 2 --> 4 --> 8 --> 9
     * newNode = 6
     * output = 1 --> 1 --> 2 --> 4 --> 6 --> 8 --> 9
     */
    public void addInASortedList(int value) {
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
    }

    // how to remove a value
    /*
     * Example
     * head = 2--> 5--> 7--> 8--> 9--> null
     * value = 5
     * Output = 2--> 7--> 8--> 9--> null
     */
    public ListNode removeAValueInAListNode(int value) {
        ListNode current = head;
        ListNode temp = null;
        if (current != null && current.data == value) {
            head = current.next;
            return head;
        }
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        temp.next = current.next;
        return head;

    }

    // how to detect a loop of a listnode
    /*
     * Example
     * head = 2--> 7--> 8--> 9--> 4--> 18--> 8(in position 3)
     * output = true
     * 
     * 
     * Example 2
     * head = 2--> 7--> 8--> 9--> null
     * output = false
     */

    public boolean detectLoop(ListNode hd) {
        ListNode fastPointer = hd;
        ListNode slowPointer = hd;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public ListNode createALoopList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(18);
        ListNode forth = new ListNode(73);
        ListNode fifth = new ListNode(5);
        head = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = third;
        return head;
    }
    // floyd's cycle detection algoryth

    // finding the start of the loop
    public ListNode detectingStartingPointOfALoop(ListNode cycle) {
        ListNode fastPointer = cycle;
        ListNode slowPointer = cycle;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                return getStartingNode(slowPointer, cycle);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPointer, ListNode cycle) {
        ListNode temp = cycle;
        while (slowPointer != temp) {
            temp = temp.next;
            slowPointer = slowPointer.next;
        }
        return temp;
    }

    // removing the end of the loop to point null
    private void removeLoopByPointingLastNodeToNull() {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (slowPointer == fastPointer) {
                removeloop(slowPointer);
            }
        }
    }

    private void removeloop(ListNode slowPointer) {
        ListNode temp = head;
        while (slowPointer.next != temp.next) {
            temp = temp.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = null;
    }

}
