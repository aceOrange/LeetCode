public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] cnt = new int[len+1];
        
        for (int c : citations) {
            if (c > len) {
                cnt[len]++;
            } else {
                cnt[c]++;
            }
        }
        
        int total = 0;
        for (int i = len; i>=0; i--) {
            total += cnt[i];
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }
}