// Time: O(N), Space: O(N)
// Correctness: 100%, Performance: 55% => Result: 76% 
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println('this is a debug message');

class Solution {
    public String solution(String S) {
        //Perform transformations using Stack
        Stack<Character> transformations  = new Stack<>();

        //Keep a map of pairs that get transformed
        Map<Character, Character> transformationRules = new HashMap<>();
        transformationRules.put('A','B');
        transformationRules.put('B','A');
        transformationRules.put('C','D');
        transformationRules.put('D','C');

        for(int i=0; i<S.length(); i++) {

            //If transformation stack is empty, add to the stack and continue
            if(transformations.empty()){
                transformations.push(S.charAt(i));
                continue;
            }

            // If transformation stack has some data, peek and check if pair for transformation is found
            if(transformations.peek() == transformationRules.get(S.charAt(i))){
                //Pop for transformation
                transformations.pop();
            } else {
                //Push if no transformation
                transformations.push(S.charAt(i));
            }
        }

        //Pop from stack and form the values remaining in reverse order
        String value = "";
        while(!transformations.empty()){
            value = transformations.pop() + value;    
        }

        //Return value
        return value;

    }
}
