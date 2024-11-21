package platform.codingnomads.co.javaLogicPuzzles;

import java.util.Stack;

public class ParenthesesPuzzle {
    public boolean checkIfMatch(String word){
        Stack<Character> balanced = new Stack();
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == '(' || word.charAt(i) == '[' || word.charAt(i) == '{'){
                balanced.push(word.charAt(i));
            }else if(!balanced.empty() && ((word.charAt(i) == ')' && balanced.peek() == '(')
                    || (word.charAt(i) == ']' && balanced.peek() == '[')
                    || (word.charAt(i) == '}' && balanced.peek() == '{'))){
                balanced.pop();
            }else if(word.charAt(i) == ')' || word.charAt(i) == ']' || word.charAt(i) == '}'){
                balanced.push(word.charAt(i));
            }
        }
        if(!balanced.empty()){
            return false;
        }else{
            return true;
        }
    }
}
