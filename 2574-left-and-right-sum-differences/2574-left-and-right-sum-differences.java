class Solution {
    public int[] leftRightDifference(int[] n) {
        int len = n.length, r = 0;
        int[] ans = new int[len];
        for (int k : n) r += k;
        for (int i = 0, l = 0; i < len; ++i) {
            r -= n[i];
            ans[i] = Math.abs(l - r);
            l += n[i];
        }
        return ans;
    }
}