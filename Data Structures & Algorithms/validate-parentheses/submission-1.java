class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character, Character> bracks=new HashMap<>();
        bracks.put(')','(');
        bracks.put(']','[');
        bracks.put('}','{');

        for(char c:s.toCharArray()){
            if(bracks.containsKey(c)){
                if(!stack.isEmpty() && stack.peek()==bracks.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
