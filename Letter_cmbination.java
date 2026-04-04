class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        
        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };
        
        f(digits, 0, new StringBuilder(), res, map);
        return res;
    }
    
    void f(String d, int i, StringBuilder cur, List<String> res, String[] map){
        if(i == d.length()){
            res.add(cur.toString());
            return;
        }
        
        String s = map[d.charAt(i) - '0'];
        
        for(char c : s.toCharArray()){
            cur.append(c);
            f(d, i+1, cur, res, map);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
