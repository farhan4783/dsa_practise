class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res= new ArrayList<>();
        solve(n, 0,0,"",res);
        return res;
    }
    void solve(int n, int l, int r, String s, List<String> res){
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(l<n)
        solve(n, l+1, r, s+'(', res);
        if(r<l)
        solve(n, l, r+1, s+')', res);
    }
    
}
