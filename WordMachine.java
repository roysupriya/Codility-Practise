// Time: O(N), Space: O(N)

// you can also use imports, for example:
import java.util.*;
import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
      Stack<Integer> machine = new Stack<>();

      String value = "";
      for(int i=0; i<S.length(); i++){          
         // Blank encountered, process the value captured so far
         if(S.charAt(i) == ' ' || i == S.length()-1) {
             if(value.isEmpty() && i != S.length()-1){
                 continue;
             } else {
                 if(i == S.length() - 1){
                     value = value + S.charAt(i);
                 }

                 if(value.equals("+")){
                    // Perform addition  
                    if(machine.size() < 2){
                        return -1;
                    }
                    machine.push(machine.pop() + machine.pop()); 

                 } else if (value.equals("-")) {
                     // Perfrom subtraction
                    if(machine.size() < 2){
                        return -1;
                    }
                    int num1 = machine.pop();
                    int num2 = machine.pop();
                    machine.push(num1 - num2);

                 } else if (value.equals("DUP")){
                     // Duplicate the last value in stack
                     if(machine.empty()){
                        return -1;
                     }

                    machine.push(machine.peek());

                 } else if (value.equals("POP")) {
                     // POP the last value in stack
                     if(machine.empty()){
                        return -1;
                     }

                    machine.pop();
                 } else {
                     // Must be an integer, push it onto the word machine stack
                     machine.push(Integer.parseInt(value));                     
                 }

                 //Reset the value after each operation
                 value = "";
             }
         }
         //Blank not encountered yet, keep accumulating the characters in value 
         else {
             value = value + S.charAt(i);
         } 
      }

      if(machine.empty() || machine.peek() >= (Math.pow(2,20) - 1))
        return -1;

      return machine.pop();
    }
}
