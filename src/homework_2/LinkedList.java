package homework_2;

public class LinkedList {
    /**
     * Необходимо реализовать метод разворота связного списка
     * (двухсвязного или односвязного на выбор).
     */
    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public static void main(String args[]){
        int myArray[] = {3, 32, 23, 56, 34, 7, 3, 7, 75, 4, 28};
        LinkedList list = new LinkedList();
        for (int i = 0; i < myArray.length; i++){
            list.add(myArray[i]);
        }
        System.out.println("Исходный список:");
        list.printList();
        list.reverse();
        System.out.println();
        System.out.println("Развернутый список:");
        list.printList();
    }

    // метод для вставки нового элемента в наш список
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    // метод для поиска элемента
    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // метод удалания элемента
    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    // разворот списка
    public void reverse() {
        Node currentNode = head;
        while (currentNode!=null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous==null){
                tail=currentNode;
            }
            if (next==null){
                head=currentNode;
            }
            currentNode=next;
        }
    }

    public void printList(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.value);
            currentNode = currentNode.next;
            if (currentNode != null)
                System.out.print(" -> ");
        }
    }
}
