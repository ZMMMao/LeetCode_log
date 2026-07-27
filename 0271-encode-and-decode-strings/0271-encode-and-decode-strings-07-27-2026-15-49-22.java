/**
encode: str length + # + str content
decode: read, adjust idx, convert
TC: O(n), n total chars in the string
SC: O(n)
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return "";

        StringBuilder encoded = new StringBuilder();
        for(String str : strs){
            encoded.append(str.length()).append('#').append(str);
        }

        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();

        List<String> decoded = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int j = i;
            while(s.charAt(j) != '#') j++;
            int size = Integer.parseInt(s.substring(i, j));
            decoded.add(s.substring(j+1, j + size + 1));
            i = j + size + 1;
        } 
        
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));