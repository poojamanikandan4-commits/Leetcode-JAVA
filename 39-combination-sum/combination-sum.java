class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Stores final answer
        List<List<Integer>> ans = new ArrayList<>();

        // Sorting helps in pruning
        Arrays.sort(candidates);

        // Start backtracking
        backtrack(candidates, target, 0, ans, new ArrayList<>());

        return ans;
    }

    public void backtrack(int[] arr,
                          int target,
                          int start,
                          List<List<Integer>> ans,
                          List<Integer> ds) {

        // Base condition
        // Valid combination found
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Try every possible element
        for (int i = start; i < arr.length; i++) {

            // Pruning
            // No need to continue if current element exceeds target
            if (arr[i] > target) break;

            // Choose current element
            ds.add(arr[i]);

            // Recurse
            // Pass i again because reuse is allowed
            backtrack(arr, target - arr[i], i, ans, ds);

            // Backtrack
            // Remove last chosen element
            ds.remove(ds.size() - 1);
        }
    }
}