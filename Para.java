import java.util.*;
public class Para {
    static boolean isValid(String as) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<as.length();i++) {
            char ch=as.charAt(i);
            if(ch=='{' || ch=='[' || ch=='(') {
                st.push(ch);
            }
            else {
                char top=st.pop();
                if((ch=='{' && top!='}') || (ch=='[' && top!=']') || (ch=='(' && top!=')')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        String[] s=new String[n];
        for(int i=0;i<n;i++) {
            s[i]=in.next();
        }
        for(int i=0;i<n;i++) {
            if(isValid(s[i])) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        }
    }
}
