class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;
        if (s.length() == 1)
            return 0;
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                // Character.toString() ensures correct lookup for supplementary code points
                return s.indexOf(entry.getKey());
            }
        }

        return -1;

    }
}