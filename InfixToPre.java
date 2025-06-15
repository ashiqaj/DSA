import java.util.*;
class InfixToPre {
    static int precedence(char ch) {
        if(ch=='+' || ch=='-') return 1;
        if(ch=='*' || ch=='/') return 2;
        if(ch=='^') return 3;
        return 0;
    }
    static String infixToPost(String s) {
        Stack<Character> ops=new Stack<>();
        StringBuffer st=new StringBuffer(s);
        StringBuffer res=new StringBuffer();
        for(char ch:st.reverse().toString().toCharArray()) {
            if(Character.isDigit(ch)) {
                res.append(ch);
            }
            else if(ch==')') {
                ops.push(ch);
            }
            else if(ch=='(') {
                while(ops.peek()!=')') {
                    res.append(ops.pop());
                }
                ops.pop();
            }
            else {
                while(!ops.isEmpty() && ops.peek()!='(' && 
                      (precedence(ch) < precedence(ops.peek()) || 
                       (precedence(ch) == precedence(ops.peek()) && ch != '^'))) {
                    res.append(ops.pop());
                }
                ops.push(ch);
            }
        }
        while(!ops.isEmpty()) {
            res.append(ops.pop());
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String s="3+(4*5/3)+8";
        System.out.println("Result: "+infixToPost(s));
    }
}