class Solution {
    public String reverseWords(String s) {
        String [] word = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            res.append(word[i]);
            if(i!=0){
                res.append(" ");
            }

        }
        return res.toString().trim();
    }
}