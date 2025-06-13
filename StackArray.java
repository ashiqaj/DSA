import java.util.Scanner;
class stack {
    int arr[]=new int[5];
    int top=-1;
    void push(int data) {
        if(top==arr.length-1) {
            System.out.println("Stack is full");
        }
        else  {
            arr[++top]=data;
        }
    }
    void pop() {
        if(top==-1) {
            System.out.println("Stack is Empty");
        }
        else{
            System.out.println("Poped Element : "+arr[top--]);
        }
    }
    void display() {
        if(top==-1) {
            System.out.println("Stack is Empty");
        }
        else{
            for(int i=top;i>=0;i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
public class StackArray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int ch;
        stack p=new stack();
        do {
            System.out.println("Choice 1 : Push\nChoice 2 : Pop\nChoice 3 : Display\nAny other choice : Exit");
            System.out.println("Enter the Choice:");
            ch=in.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the Value:");
                    int data=in.nextInt();
                    p.push(data);
                    break;
                case 2:
                    p.pop();
                case 3:
                    p.display();
                default:
                    break;
            }
        }while(ch>0 && ch<4);

    }
}
