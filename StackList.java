import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data=data;
    }
}
public class StackList {
    Node top;
    int count=0;
    void push(int data) {
        Node n=new Node(data);
        if(top==null) {
            top=n;
        }
        else {
            n.next=top;
            top=n;
        }
        count++;
    }
    int pop() {
        if(top==null) {
            System.err.println("Stack is Empty");
            return -1;
        }
        int data=top.data;
        top=top.next;
        return data;
    }
    int peek() {
        if(top==null) {
            System.err.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }
    void display() {
        if(top==null) {
            System.err.println("Stack is Empty");
            return;
        }
        Node temp=top;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    int COUNT() {
        return count;
    }
    public static void main(String[] args) {
        StackList li=new StackList();
        Scanner in=new Scanner(System.in);
        int ch;
        do {
            System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nAny other choice : Exit");
            System.out.println("Enter the Choice:");
            ch=in.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value:");
                    int data=in.nextInt();
                    li.push(data);
                    break;
                case 2:
                    System.out.println("Poped Element : "+li.pop());
                    break;
                case 3:
                    li.display();
                    break;
                default:
                    break;
            }
        }while(ch>0 && ch<4);
    }
}
