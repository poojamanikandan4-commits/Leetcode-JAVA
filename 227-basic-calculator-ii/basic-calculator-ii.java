class Solution {
    public int calculate(String s) 
    {
        int n = s.length();
        int ans = 0;
        int prev = 0;
        char op = '+';

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch))
            {
                int cur = ch - '0';

                while(i + 1 < n && Character.isDigit(s.charAt(i + 1)))
                {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                if(op == '+')
                {
                    ans += cur;
                    prev = cur;
                }
                else if(op == '-')
                {
                    ans -= cur;
                    prev = -cur;
                }
                else if(op == '*')
                {
                    ans -= prev;
                    ans += prev * cur;
                    prev = prev * cur;
                }
                else
                {
                    ans -= prev;
                    ans += prev / cur;
                    prev = prev / cur;
                }
            }
            else if(ch != ' ')
            {
                op = ch;
            }
        }

        return ans;
    }
}