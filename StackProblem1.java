import java.util.*;
class Arr {
    int arr[];
    Arr(int size) {
        arr=new int[size];
    }
    int top=-1;
    void push(int data) {
        if(top==arr.length-1) {
            System.out.println("Stack is full");
        }
        else  {
            arr[++top]=data;
        }
    }
    int pop(int flag) {
        if(top==-1) {
            System.out.println("Stack is Empty");
            return 0;
        }
        int x= arr[top];
        top=top+(1*flag);
        return x;
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
public class StackProblem1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int id=in.nextInt();
        int flag=-1;
        Arr st=new Arr(n);
        for(int i=0;i<n;i++) {
            char ch=in.next().charAt(0);
            if(ch=='F') {
                int x=in.nextInt();
                st.push(x);
                flag=1;
            }
            else if(ch=='R') {
                st.pop(flag);
                flag=-1;
            }
        }
        System.err.println("Player "+st.pop(flag));
    }
}