class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        int currOrderFinishesAt = customers[0][0] + customers[0][1];
        totalWaitingTime += (currOrderFinishesAt - customers[0][0]);
        for(int i = 1; i < customers.length; i++){
            if(currOrderFinishesAt <= customers[i][0]){
                currOrderFinishesAt = customers[i][0] + customers[i][1];    
            }else{
                currOrderFinishesAt += customers[i][1];
            }
            // Waiting time = finish time - arrival time
            totalWaitingTime += (currOrderFinishesAt - customers[i][0]);
        }
        return (double) totalWaitingTime / customers.length;
    }
}