public class Solution {
    
    private static final HashMap<Character, Character[]> set=new HashMap<Character, Character[]>() {{
        put('2', new Character[] {'a','b','c'});
        put('3', new Character[] {'d','e','f'});
        put('4', new Character[] {'g','h','i'});
        put('5', new Character[] {'j','k','l'});
        put('6', new Character[] {'m','n','o'});
        put('7', new Character[] {'p','q','r','s'});
        put('8', new Character[] {'t','u','v'});
        put('9', new Character[] {'w','x','y','z'});
    } };
        
    public List<String> letterCombinations(String digits) {
 
        List<String> list=new ArrayList<String>();
        if (!digits.isEmpty()) 
            addUp(0, digits, new StringBuilder(), list);
        
        return list;
    }
    
    public void addUp(int start, String digits, StringBuilder s, List<String> list) {
        
        if (s.length()==digits.length()) list.add(s.toString());
        else {
        
            for (int i=start; i<digits.length(); i++) 
                for (char c: set.get(digits.charAt(i))) {
                    s.append(c);
                    addUp(i+1, digits, s, list);
                    s.deleteCharAt(s.length()-1);
                }
                
        }
    }
}