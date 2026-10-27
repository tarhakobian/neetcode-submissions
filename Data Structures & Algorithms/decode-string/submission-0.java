class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ']') {
                StringBuilder seq = new StringBuilder();

                // Extract the encoded sequence
                while (stack.peek() != '[') {
                    seq.append(stack.pop());
                }

                stack.pop(); // Remove '['
                seq.reverse();

                // Extract multiplier
                StringBuilder num = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.append(stack.pop());
                }

                int multiplier = Integer.parseInt(num.reverse().toString());

                // Push decoded sequence back onto stack
                for (int j = 0; j < multiplier; j++) {
                    for (int k = 0; k < seq.length(); k++) {
                        stack.push(seq.charAt(k));
                    }
                }

            } else {
                stack.push(ch);
            }
        }

        // Construct final result
        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}

// class Solution {
//     public String decodeString(String s) {
//         Deque<Integer> stack = new ArrayDeque<>();
//         StringBuilder res = new StringBuilder();

//         for(int i = 0; i < s.length(); i++){
//             if(s.charAt(i) == ']'){
//                 //TODO : pop and append to res
//                 StringBuilder seq = new StringBuilder();
//                 char popped;
//                 while ((popped = stack.pop()) != '[') {
//                     seq.append(popped);
//                 }
//                 String toAppend = seq.reverse().toString();
//                 int multiplier = stack.pop();
//                 for(int j = 0; j < multiplier; j++){
//                     res.append(toAppend);
//                 }
//             }else if(s.charAt(i).isNumeric()){
//                 Integer number = 0;
//                 for(int j = i + 1; j < s.length(); j++){
//                     number = number * 10 + Integer.valueOf(s.charAt(i));
//                 }
//                 stack.push(number.toString());
//             }else{
//                 stack.push(s.charAt());
//             }
//         }

//         StringBuilder tail = new StringBuilder();
//         while(!stack.isEmpty()){
//             tail.append(stack.pop());
//         }

//         if(tail.length() > 0){
//             res.append(tail.reverse().toString());
//         }
        
//         return res.toString();
//     }
// }