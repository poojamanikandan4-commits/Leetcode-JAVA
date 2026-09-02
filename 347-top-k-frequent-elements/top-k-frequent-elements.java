class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> buckets = new ArrayList<>();  
        
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets.get(freq).add(num);
        }
        
        int[] res = new int[k];
        int idx = 0;
        for (int i = n; i >= 0 && idx < k; i--) {
            for (int num : buckets.get(i)) {
                res[idx++] = num;
                if (idx >= k) break;
            }
        }
        
        return res;
    }
}