class Solution {
    /**
    three types of parentheses
    stack
    HashMap
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                if(stack.peek() == map.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
/**
TC: O(n)
SC: O(n)
 */