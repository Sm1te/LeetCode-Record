class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int index = 0;
        int n = ch.length;
        while(index < n){
            if(n - index < k){
                reverse(ch, index, ch.length - 1);
                index = n;
            }else{
                reverse(ch, index, index + k - 1);
                index += 2 * k;
            }
        }
        return new String(ch);
    }

    public void reverse(char[] ch, int l, int r){
        while(l < r){
            char tmp = ch[l];
            ch[l] = ch[r];
            ch[r] = tmp;
            r--;
            l++;
        }
    }
}