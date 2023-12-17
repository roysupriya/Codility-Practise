/*
Problem: https://app.codility.com/programmers/lessons/8-leader/dominator/
Results: 
  87% (fails for n/2 and n/2+1) division:https://app.codility.com/demo/results/training8RRQR2-38V/ 
  100% https://app.codility.com/demo/results/trainingEQWZ5A-53F/

Time: O(N), Space: (N)

An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

import java.util.*;

class Solution {
    public int solution(int[] A) {

       // Use map to store element and occurence
       // check if occurence is n/2 times to see if its a dominator or not
       // Traverse the array to find the first occurrence 

       Map<Integer, Integer> map = new HashMap<>();

       for(int i=0; i<A.length; i++){
           if(!map.containsKey(A[i])){
               map.put(A[i], 1);
           } else {
               map.put(A[i], map.get(A[i]) + 1);
           }
        }

        int maxCount = -1, maxElement = -1;
        for(Map.Entry entry: map.entrySet()){
            if(maxCount<(int) entry.getValue()){
                maxCount = (int) entry.getValue();
                maxElement = (int) entry.getKey();
            }
        }

        if(maxCount <= A.length/2){ //Count is less than N/2 + 1
            return -1;
        } else { // Find the index of the max element
            for(int i=0; i<A.length; i++){
                if(A[i] == maxElement){
                    return i;
                }
            }
        }

        // Control shouldn't reach here, but anyway for compiler
        return -1;
    }
}
