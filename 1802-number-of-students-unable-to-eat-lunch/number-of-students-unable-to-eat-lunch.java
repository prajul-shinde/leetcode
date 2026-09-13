class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int student : students) {
            queue.add(student);
        }

        int sandwichIdx = 0;
        int unableToEatCount = 0;

        // Loop runs as long as the queue has students AND at least one student in the current cycle ate
        while (!queue.isEmpty() && unableToEatCount < queue.size()) {
            if (queue.peek() == sandwiches[sandwichIdx]) {
                queue.poll(); // Student eats sandwich and leaves line
                sandwichIdx++; // Advance to next top sandwich
                unableToEatCount = 0; // Progress made, reset rotation counter
            } else {
                queue.add(queue.poll()); // Student doesn't want sandwich, move to back
                unableToEatCount++;
            }
        }

        return queue.size();
    }
}