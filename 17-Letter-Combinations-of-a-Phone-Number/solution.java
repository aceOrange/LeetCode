public class Solution {
    
    private HashMap<Character, Character[]> map = new HashMap<Character, Character[]>(); 
        
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) {
            return list;
        }
        
        //initialize the HashMap
        map.put('2', new Character[] {'a','b','c'});
        map.put('3', new Character[] {'d','e','f'});
        map.put('4', new Character[] {'g','h','i'});
        map.put('5', new Character[] {'j','k','l'});
        map.put('6', new Character[] {'m','n','o'});
        map.put('7', new Character[] {'p','q','r','s'});
        map.put('8', new Character[] {'t','u','v'});
        map.put('9', new Character[] {'w','x','y','z'});
        
        dfs(0, digits, new StringBuilder(), list);
       
        return list;
    }
    
    public void dfs(int start, String digits, StringBuilder sb, List<String> list) {
        
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            for (char c: map.get(digits.charAt(i))) {
                sb.append(c);
                dfs(i+1, digits, sb, list);
                sb.deleteCharAt(sb.length()-1);
            }
        }    
    }
}