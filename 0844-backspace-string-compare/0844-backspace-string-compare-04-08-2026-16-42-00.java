class Solution {
    public boolean backspaceCompare(String s, String t) {
        if(s == null || t == null) return s == t;
        return build(s).equals(build(t));
    }
    private String build(String a){
        Deque<Character> stack = new ArrayDeque<>();
 
        for(char c : a.toCharArray()){
            if(c == '#'){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.toString();
    }
}