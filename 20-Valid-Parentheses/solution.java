public class Solution {
    private static final HashMap<Character,Character> map = new HashMap<Character,Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};
    
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<Character>();
       if (s.length() % 2 != 0) return false;
       
       for (int i=0; i<s.length(); i++) {
           Character c=s.charAt(i); 
           if (stack.isEmpty() || map.containsKey(c)) {
                stack.push(c);
           }
           else {
                if (map.get(stack.pop()) != c) return false; 
           }
       }
       return stack.isEmpty();
    }
}