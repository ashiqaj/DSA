class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data=data;
    }
}
public class DoublyList {
    Node head,tail;
    void insertEnd(int data) {
        Node n=new Node(data);
        if(head==null) {
            head=n;
            tail=n;
        }
        else {
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    }
    void insertBegin(int data) {
        Node n=new Node(data);
        n.next=head;
        head.prev=n;
        head=n;
    }
    void insertPos(int pos,int data) {
        Node temp=head;
        Node n=new Node(data);
        for(int i=1;i<pos-1;i++) {
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
        n.prev=temp;
        temp.next.prev=n;
    }
    void delEnd() {
        Node temp=head;
        while(temp.next!=tail) {
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
    }
    void delBegin() {
        head.prev=null;
        head=head.next;
    }
    void delPos(int pos) {
        Node temp=head;
        for(int i=1;i<pos-1;i++) {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.prev=temp.next;
    }
    void display() {
        Node temp=head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    void reverse() {
        Node temp=tail;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.prev;
        }
    }
    void search(int key) {
        Node temp=head;
        int pos=1;
        while(temp!=null) {
            if(temp.data==key) {
                System.out.println(key+" is present in the "+pos+" position of the list");
                return;
            }
            pos++;
            temp=temp.next;
        }
        System.out.println(key+" is not present in the list");
    }
    int findMax() {
        Node temp=head;
        int max=temp.data;
        while(temp!=null) {
            if(max<temp.data) {
                max=temp.data;
            }
            temp=temp.next;
        }
        return max;
    }
    public static void main(String[] args) {
        DoublyList li=new DoublyList();
        li.insertEnd(10);
        li.insertEnd(20);
        li.insertBegin(30);
        li.insertPos(2, 40);
        li.display();
        System.out.println("After Reverse:");
        li.reverse();
    }
}
