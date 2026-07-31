/**
stack
peek == curr, pop if not left - push , right return false;
TC: O(n)
SC: O(n)
 */
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() <= 1) return false;

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> match = new HashMap<>();
        match.put(']', '[');
        match.put('}', '{');
        match.put(')', '(');

        for(int i = 0; i< s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                stack.push(curr);
            }else if(!stack.isEmpty() && stack.peek() == match.get(curr)){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}