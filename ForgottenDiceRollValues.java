class Solution {
    public int[] solution(int[] A, int F, int M) {
        
        //Time: O(N + F), Space: O(1)

        int diceRollCount = A.length + F;
        int sumKnownDiceRoll = A[0];
        int maxDiceRollValue = 6;
        int totalDiceRollValue = M*diceRollCount;
        int sumMaxForgottenDiceRoll = F*maxDiceRollValue;

        //Get the total sum of known dice rolls: O(N)
        for (int i=1; i<A.length; i++){
            sumKnownDiceRoll += A[i];
        }

        // Check for failure case: If mean is not attainable considering max result of each forgotten dice roll, we return [0]
        if((totalDiceRollValue - sumKnownDiceRoll < 0) || (sumMaxForgottenDiceRoll < (totalDiceRollValue - sumKnownDiceRoll))){
            return new int[]{0};
        } 
        // Check for success case when all forgotten dice roll could be 6s
        else if (sumMaxForgottenDiceRoll == (totalDiceRollValue - sumKnownDiceRoll)){
            int[] forgottenDiceRolls = new int[F];
            for(int i=0; i<F; i++){
                forgottenDiceRolls[i] = 6;
            }
            return forgottenDiceRolls;
        }

        //Try to form the dice roll output for the only remaining scenario
        int[] forgottenDiceRolls = new int[F]; //Default initializes to 0s
        int sumForgottenDiceRoll = totalDiceRollValue - sumKnownDiceRoll;
        int minDiceRollValue = (sumForgottenDiceRoll)/F;

        //In single pass initialize all cells with min dice roll value: O(F)
        for(int i=0; i<F; i++){
                forgottenDiceRolls[i] = minDiceRollValue; 
                sumForgottenDiceRoll -= minDiceRollValue;
        }

        //In next pass put the remaining dice roll value. Only one pass would be needed: O(F)
        for(int i=0; i<F; i++){
            if(sumForgottenDiceRoll > 0){
                forgottenDiceRolls[i]++; 
                sumForgottenDiceRoll--;
            }
            break;
        }


        return forgottenDiceRolls;
    }
}
