/**
input:
    type: String
    length: [1, 10^5]
    letter range: a, b, c
output:
    int
edgecase:
    s == null return 0;
approach:
    brute force: dfs, list all the comb of substring, a helper function counted
        TC: O(n^2)
        SC: O(1)
    optimal: 
 
dry run sample:
    input: s = "abbac"
    'a':
        count: [1, 0, 0], maxLen = 1
    'ab':
        count: [1, 1, 0], maxLen = 2
    'abb':
        count: [1, 2, 0], ** not balanced **
    'abba'
    
 
*/ 

// class Solution {
//     public int longestBalanced(String s) {
//         if(s == null || s.length() == 0) return 0;

//         int n = s.length();
//         int maxLen = 0;
//         for(int i = 0; i < n; i++){
//             int[] count = new int[3];
//             for(int j = i; j < n; j++){
//                 char curr = s.charAt(j);
//                 count[curr - 'a']++;
//                 if(isBalanced(count)){
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 }
//             }
//         }
//         return maxLen;
//     }

//     private boolean isBalanced(int[] count){
//         int target = -1;
//         for(int c : count){
//             if(c > 0){
//                 if(target == -1){
//                     target = c;
//                 }else{
//                     if(c != target) return false;
//                 }
//             }
//         }
//         return target != -1;
//     }
// }

class Solution {
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int x = calc1(cs);
        int y = Math.max(calc2(cs, 'a', 'b'), Math.max(calc2(cs, 'b', 'c'), calc2(cs, 'a', 'c')));
        int z = calc3(cs);
        return Math.max(x, Math.max(y, z));
    }

    private int calc1(char[] s) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    private int calc2(char[] s, char a, char b) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            while (i < n && s[i] != a && s[i] != b) {
                i++;
            }
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1);
            int d = 0;
            while (i < n && (s[i] == a || s[i] == b)) {
                d += (s[i] == a) ? 1 : -1;
                Integer prev = pos.get(d);
                if (prev != null) {
                    res = Math.max(res, i - prev);
                } else {
                    pos.put(d, i);
                }
                i++;
            }
        }
        return res;
    }

    private int calc3(char[] s) {
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(f(0, 0), -1);

        int[] cnt = new int[3];
        int res = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            ++cnt[c - 'a'];
            int x = cnt[0] - cnt[1];
            int y = cnt[1] - cnt[2];
            long k = f(x, y);

            Integer prev = pos.get(k);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                pos.put(k, i);
            }
        }
        return res;
    }

    private long f(int x, int y) {
        return (x + 100000) << 20 | (y + 100000);
    }
}