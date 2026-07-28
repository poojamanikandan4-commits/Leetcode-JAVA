class Solution {
    public int digitFrequencyScore(int n) {
        int[] arr = new int[10];
        int cpy = n;
        while(cpy != 0){
            arr[cpy%10]++;
            cpy /= 10;
        }
        int sum = 0;
        for(int i = 0; i<10; i++){
            sum += i*arr[i];
        }
        return sum;
    }
}