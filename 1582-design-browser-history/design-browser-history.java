class BrowserHistory {

    private static class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }

    private Node curr;

    public BrowserHistory(String homepage) {
        this.curr = new Node(homepage);
    }

    // O(1) Time - Overwrites forward history and moves pointer
    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    // O(min(steps, length)) Time - Walks back until steps run out or reaches oldest page
    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    // O(min(steps, length)) Time - Walks forward until steps run out or reaches latest page
    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */