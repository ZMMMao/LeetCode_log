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
        
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(!map.containsKey(ch[i])){
                stack.push(ch[i]);
            }else{
                if(stack.peek() == map.get(ch[i])){
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