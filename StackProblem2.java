import java.util.Scanner;
class Stock {
    int arr[];
    Stock(int size) {
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
        top+=flag;
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
    int stockCount() {
        int c=0;
        for(int i=top;i>=0;i--) {
            if(arr[i]<=arr[top]) {
                c++;
            }
            else
            break; 
        }
        return c;
    }
}
public class StackProblem2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of days");
        int n=in.nextInt();
        Stock st=new Stock(n);
        int res[]=new int[n];
        System.out.println("Enter the stock prices ");
        for(int i=0;i<n;i++) {
            int x=in.nextInt();
            st.push(x);
            res[i]=st.stockCount();
        }
        System.out.println("Span Values ");
        for(int i=0;i<n;i++) {
            System.out.print(res[i]+" ");
        }
    }
}
