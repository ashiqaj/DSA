class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}
class Queue {
    Node front,rear;
    boolean isEmpty() {return (front==null && rear==null);}
    void enQueue(int data) {
        Node n=new Node(data);
        if(isEmpty()) {
            front=n;
            rear=n;
        }
        else {
            rear.next=n;
            rear=n;
        }
    }
    int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return 0;
        }
        int t=front.data;
        front=front.next;
        return t;
    }
    void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
        }
        Node temp=front;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}
public class QueueList {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.deQueue();
        q.display();
    }
}
