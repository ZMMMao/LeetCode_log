/**
map the brackets
stack

Input: s = "()"

Output: true

edge case:
empty s
same left bracket s
pairs of brackets
all right brackets
large size of brackets
random order of pairs of brackets
1 kind of brackets
right brackets first and left brackets after
 */

class Solution {
    public boolean isValid(String s) {
        
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(mapping.containsKey(c) && !stack.isEmpty() && mapping.get(c) == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}