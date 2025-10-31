public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs){
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int idx = i;
            while(s.charAt(idx) != '#'){
                idx++;
            }
            int len = Integer.valueOf(s.substring(i, idx));
            int start = idx + 1;
            int end = start + len;
            res.add(s.substring(start, end));
            i = end;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
/**
TC: O(n)
SC: O(n)
 */