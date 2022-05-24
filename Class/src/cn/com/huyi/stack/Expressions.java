package cn.com.huyi.stack;

/**
 * @title: Expressions
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/15 9:08
 **/

public class Expressions {
    public static boolean isMatch(String expstr){
        Stack<String> stack = new SeqStack<String>();
        for (int i = 0; i < expstr.length(); i++) {
            char ch = expstr.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(")");
                    break;
                case '[':
                    stack.push("]");
                    break;
                case '{':
                    stack.push("}");
                    break;


                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty()) return false;
                    else if(!stack.pop().equals(ch+"")){
                        return false;
                    }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
