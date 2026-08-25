class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        // Hexadecimal characters
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        // Use unsigned shifting for 32-bit numbers
        while (num != 0 && sb.length() < 8) {
            int hexDigit = num & 15; // num % 16
            sb.append(hexChars[hexDigit]);
            num >>>= 4; // unsigned right shift
        }
        
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.toHex(26));   // Output: "1a"
        System.out.println(sol.toHex(-1));   // Output: "ffffffff"
        System.out.println(sol.toHex(0));    // Output: "0"
        System.out.println(sol.toHex(305419896)); // Output: "12345678"
    }
}