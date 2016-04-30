public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>();
        if (S.length()==0 || L.length==0) return list;
        int wL=L[0].length();
        if (wL==0 || wL*L.length > S.length()) return list;
        
        Map<String, Integer> mapL = new HashMap<>();
        for (String str: L) {
            if (!mapL.containsKey(str))     mapL.put(str, 1);
            else                            mapL.put(str, mapL.get(str)+1);
        }
        
        for (int i=0; i<S.length(); i++) {
            int count = 0;
            Map<String, Integer> mapS=new HashMap<>();
            for (int j=i; j<=S.length()-wL; j+=wL) {
                String currWord = S.substring(j, j+wL);
                if (!mapL.containsKey(currWord)) break;
                else {
                    if (!mapS.containsKey(currWord))    mapS.put(currWord, 1);
                    else    mapS.put(currWord, mapS.get(currWord)+1);
                    
                    if (mapS.get(currWord) > mapL.get(currWord)) break;
                    else    count++;
                    
                    if (count == L.length) {
                        list.add(i);
                        break;
                    }
                }
            }
        }
        
        return(list);
    }
}