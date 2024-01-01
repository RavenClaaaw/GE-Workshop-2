public class LinkedList<T> {
    Node<T> head;

    LinkedList(){
        this.head = new Node<>(null);
    }

    public void add(T value){
        Node<T> current = this.head;
        while(current.next != null) current = current.next;

        Node<T> nnode = new Node<>(value);
        current.next = nnode;
    }

    public void display(){
        Node<T> current = this.head.next;
        System.out.println("Linked List:- ");
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        } System.out.println();
    }

    public void reverse(){
        Node<T> pNode = null;
        Node<T> cNode = this.head.next;
        Node<T> nNode = null;

        while(cNode != null){
            nNode = cNode.next;
            cNode.next = pNode;
            pNode = cNode;
            cNode = nNode;
        }

        this.head.next = pNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);

        list.display();
        list.reverse();
        list.display();
    }

    // Add
    // Display
    // Reverse
}
