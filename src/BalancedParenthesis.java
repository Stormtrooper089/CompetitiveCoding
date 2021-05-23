import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedParenthesis {
    public static  void main(String [] args){
        String bracketString = "[(])";
        Stack<Character> charQueue = new Stack<Character>();
        for(int i=0 ; i< bracketString.length();i++){
            char ca = bracketString.charAt(i);
            if(ca == '(' || ca == '[' || ca == '{'){
                charQueue.add(bracketString.charAt(i));
                continue;
            }

            if( !charQueue.isEmpty()){
                char c = charQueue.pop();
                int found =0;
//                System.out.println("The queue polled element is  " +  c);
//                System.out.println("The string index checked at   " +  ca);
//                System.out.println("The size of the queue at this moment   " +  charQueue.size());
                if( c == '(' && bracketString.charAt(i) == ')' ){
                    //charQueue.poll();
                    found =1;
                    //System.out.println("The change in ()   ");
                }
                if( c == '[' && bracketString.charAt(i) == ']' ){
                    //charQueue.poll();
                    found = 1;
                    //System.out.println("The change in []   ");
                }
                if( c == '{' && bracketString.charAt(i) == '}' ){
                    //charQueue.poll();
                    found =1 ;
                    //System.out.println("The change in {}   ");
                }
                if(found == 0){
                    //System.out.println("Add karna pada ");
                    charQueue.add(c);
                }

            }
        }
        if(charQueue.isEmpty()){
            System.out.println("The stream is balance parenthesis");
        }else{
            System.out.println("The stream is not balanced");
        }
    }
}
