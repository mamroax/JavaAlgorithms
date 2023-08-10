package homework_2;

public class List {
    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek(){
        Integer result = null;
        if (tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

    private void reverse(Node currentNode, Node previousNode) {
        if (currentNode.next == null) { // базовый случай
            head = currentNode;
        } else { // рекурсивный случай
            reverse(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }


    public void reverse() {
        if (head != null && head.next != null) {
            Node temp = head;
            reverse(head.next, head);
            temp.next = null;
        }
    }
}
