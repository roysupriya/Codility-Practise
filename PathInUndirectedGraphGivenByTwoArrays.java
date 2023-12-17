import java.util.*;

class Solution {
    public boolean solution(int N, int[] A, int[] B) {
        // Maintain adjacency linked list of linked list
        // - contains list of all nodes connected to current node
        // - maintaining as 0 based index 
         LinkedHashSet<Integer>[] adjacencylist = new LinkedHashSet[N]; // 2N space max : O(N)

        // Initialize each node with empty linked list
         for(int i=0; i<N; i++){ // O(N)
             adjacencylist[i] = new LinkedHashSet<>();
         }

        // Traverse each path and mark it in the adjacency list
        // (A[i] - 1)th linked list should indicate path to (B[i]-1)th linked list and vice versa
         for(int i=0; i<A.length; i++){ // O(M)
             adjacencylist[A[i]-1].add(B[i]-1);
             adjacencylist[B[i]-1].add(A[i]-1);
         }

        // Traverse each node (ith linked list) and check if it contains path to next node (contains (i+1)th as entry)
        // We skip checking last node because we don't want to check if last node connects to first node
         for(int i=0; i<N-1; i++){ // O(N)
             if(adjacencylist[i].contains(i+1)){ //O(1)
                 continue;
             } else {
                 return false;
             }
         }

        // Total Time: O(N), Space: O(N)
         return true;
    }
}
