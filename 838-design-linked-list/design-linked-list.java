class MyLinkedList {

    // Helper Node class (fields must be accessible to MyLinkedList)
    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Sentinel dummy head
    private Node tail; // Sentinel dummy tail

    public MyLinkedList() {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        if (index < 0)
            return -1;
        var curr = this.head.next; // Start at index 0 (first real node)
        for (var i = 0; i < index && curr != tail; i++) {
            curr = curr.next;
        }
        if (curr == tail)
            return -1;
        return curr.val;
    }

    public void addAtHead(int val) {
        var newNode = new Node(val);
        newNode.prev = this.head;
        newNode.next = this.head.next;

        this.head.next.prev = newNode;
        this.head.next = newNode;
    }

    public void addAtTail(int val) {
        var newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0)
            return;
        var curr = head; // Start at dummy head (node before index 0)
        for (var i = 0; i < index && curr != tail; i++) {
            curr = curr.next;
        }

        if (curr != tail) {
            var newNode = new Node(val);
            newNode.next = curr.next;
            newNode.prev = curr;

            curr.next.prev = newNode;
            curr.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0)
            return;
        var curr = head.next; // Start at index 0 (first real node)
        for (var i = 0; i < index && curr != tail; i++) {
            curr = curr.next;
        }

        if (curr != tail) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            curr.next = null;
            curr.prev = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */