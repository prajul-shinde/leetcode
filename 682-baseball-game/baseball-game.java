class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if (op.equals("+")) {
                int top1 = stack.pop();
                int top2 = stack.peek();

                int newScore = top1 + top2;
                stack.push(top1);
                stack.push(newScore);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int previous = stack.peek();
                stack.push(2 * previous);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int totalSum = 0;
        while (!stack.isEmpty()) {
            // Pop the top number and add it to our running total
            totalSum += stack.pop();
        }

        return totalSum;
    }
}