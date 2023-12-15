/*
Problem: https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
Results: https://app.codility.com/demo/results/trainingBUKZ4R-63Z/

A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
*/

// Time complexity: O(1)
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        // Implement your solution here

        // Corner cases: Source = Destination
        if(X == Y) {
            return 0;
        }

        int distance = Y - X;

        if(distance%D != 0){
            return distance/D + 1;
        } else {
            return distance/D;
        }
    }
}

