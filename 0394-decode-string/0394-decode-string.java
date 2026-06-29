class Solution {
    public String decodeString(String s) {
         Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for(char c : s.toCharArray()) {

            if(Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            }
            else if(c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = "";
            }
            else if(c == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());

                for(int i = 0; i < repeat; i++) {
                    temp.append(currentString);
                }

                currentString = temp.toString();
            }
            else {
                currentString += c;
            }
        }

        return currentString;
    }
}