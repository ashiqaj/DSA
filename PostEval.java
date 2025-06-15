import java.util.*;
public class PostEval {
    static int evoPost(String as) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<as.length();i++) {
            char ch=as.charAt(i);
            if(Character.isDigit(ch)) {
                st.push(ch-'0');
            }
            else {
                int b=st.pop();
                int a=st.pop();
                int res=0;
                switch (ch) {
                    case '+':
                        res=a+b;
                        break;
                    case '-':
                        res=a-b;
                        break;
                    case '*':
                        res=a*b;
                        break;
                    case '/':
                        res=a/b;
                        break;
                    default:
                        break;
                }
                st.push(res);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String as=in.nextLine();
        System.out.println("Postfix Expression Result: "+evoPost(as));
    }
}
