class Solution {
    public boolean isValid(String s) {
        Stack <Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.add(s.charAt(i));
            }
            else{
                char a=s.charAt(i);
                if(st.isEmpty())
                return false;
                char b=st.pop();
                if((b=='(' && a!=')' )|| (b=='[' && a!=']') ||(b=='{' && a!='}'))
                return false;
            }
        }

        return st.isEmpty();
    }
}