class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0;
        int startInd = 0;
        int total = 0;
        int net = 0;
        for(int i=0; i<gas.length; i++){
           net = gas[i] - cost[i];
           gasInTank += net;
           total += net;
           if(gasInTank < 0){
            startInd = i+1;
            gasInTank = 0;
           }
        }
        if(total < 0) return -1;
        else return startInd;
    }
}