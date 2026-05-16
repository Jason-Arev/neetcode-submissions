class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //create new stack
        java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>(); 
        //have keys for each character
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) { //each char in an array of chars from s
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    //checks if last char contains a a return value of c
                    stack.pop(); //pops/ removes the value
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
