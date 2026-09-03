class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // Step 1: climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak cannot be first or last
        if (i == 0 || i == n - 1) return false;

        // Step 2: climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // If we reached the end, it’s a valid mountain
        return i == n - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validMountainArray(new int[]{0, 3, 2, 1})); // true
        System.out.println(sol.validMountainArray(new int[]{3, 5, 5}));    // false
        System.out.println(sol.validMountainArray(new int[]{2, 1}));       // false
        System.out.println(sol.validMountainArray(new int[]{0, 2, 3, 3, 2, 1})); // false
    }
}