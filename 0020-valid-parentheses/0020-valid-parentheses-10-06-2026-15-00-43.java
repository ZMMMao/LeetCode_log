/**
clarify:
how many type of brackets
must close in correct order and same type

approach: 
mapping the parentheses, map closed/right parenthese to left/open
stack to push and pop for correct order
TC: O(n)
SC: O(n)

 */
class Solution {
    public boolean isValid(String s) {
       if(s == null || s.length() == 0) return false;

       Deque<Character> stack = new ArrayDeque<>();
       Map<Character, Character> map = new HashMap<>();

       map.put(']', '[');
       map.put('}', '{');
       map.put(')', '(');

       for(char c : s.toCharArray()){
        if(!map.containsKey(c)){
            stack.push(c);
        }else{
            if(stack.isEmpty() || stack.pop() != map.get(c)) return false;
        }
       } 
       return stack.isEmpty();
    }
}