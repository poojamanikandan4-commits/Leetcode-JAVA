class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        // Step 1: find the first decreasing digit from the right
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such index exists, digits are in descending order
        if (i < 0) {
            return -1;
        }

        // Step 2: find the smallest digit greater than digits[i]
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: swap
        swap(digits, i, j);

        // Step 4: reverse the suffix
        reverse(digits, i + 1, digits.length - 1);

        long val = Long.parseLong(new String(digits));

        // Step 5: check 32-bit integer limit
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nextGreaterElement(12));   // Output: 21
        System.out.println(sol.nextGreaterElement(21));   // Output: -1
        System.out.println(sol.nextGreaterElement(12443322)); // Output: 13222344
    }
}