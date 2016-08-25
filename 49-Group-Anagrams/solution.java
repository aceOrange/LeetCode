public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listSet = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            String hash = getHash(s);
            if (!map.containsKey(hash)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(hash, list);
            } else {
                map.get(hash).add(s);
            }
        }
        
        for (String hash : map.keySet()) {
            listSet.add(map.get(hash));
        }
        
        return listSet;
    }
    
    public String getHash(String s) {
        int[] count = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch ='a'; ch <= 'z'; ch++) {
            if (count[ch] > 0) {
                sb.append(ch).append(count[ch]);
            }
        }
        
        return sb.toString();
    }
}