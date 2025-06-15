import java.util.*;
class InfixEval {
    static int calc(int a,int b,char op) {
        switch(op) {
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
            case '^':return (int)Math.pow(a,b);
        }
        return 0;
    }
    static int precedence(char ch) {
        if(ch=='+' || ch=='-') return 1;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='^') return 3;
        return 0;
    }
    static int eval(String s) {
        Stack<Integer> val=new Stack<>();
        Stack<Character> ops=new Stack<>();
        for(char ch:s.toCharArray()) {
            if(Character.isDigit(ch)) {
                val.push(ch-'0');
            }
            else if(ch=='(') {
                ops.push(ch);
            }
            else if(ch==')') {
                while(ops.peek()!='(') {
                    int b=val.pop();
                    int a=val.pop();
                    char op=ops.pop();
                    val.push(calc(a,b,op));
                }
                ops.pop();
            }
            else {
                while(!ops.isEmpty() && ops.peek()!='(' && 
                      (precedence(ch) < precedence(ops.peek()) || 
                       (precedence(ch) == precedence(ops.peek()) && ch != '^'))) {
                    int b=val.pop();
                    int a=val.pop();
                    char op=ops.pop();
                    val.push(calc(a,b,op));
                }
                ops.push(ch);
            }
        }
        while(!ops.isEmpty()) {
            int b=val.pop();
            int a=val.pop();
            char op=ops.pop();
            val.push(calc(a,b,op));
        }
        return val.pop();
    }
    public static void main(String[] args) {
        String s="3+(4*5/3)+8";
        System.out.println("Result: "+eval(s));
    }
}