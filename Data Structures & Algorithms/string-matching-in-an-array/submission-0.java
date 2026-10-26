
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        
        // Sort the array by increasing length of strings
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Since words[j] is longer or equal, check if words[i] is a substring
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break; // Found a match, no need to check further for words[i]
                }
            }
        }
        
        return res;
    }
}