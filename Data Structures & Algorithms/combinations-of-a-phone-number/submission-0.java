class Solution {
    private static final Map<Character, List<Character>> map = Map.ofEntries(
        Map.entry('2', List.of('a', 'b', 'c')),
        Map.entry('3', List.of('d', 'e', 'f')),
        Map.entry('4', List.of('g', 'h', 'i')),
        Map.entry('5', List.of('j', 'k', 'l')),
        Map.entry('6', List.of('m', 'n', 'o')),
        Map.entry('7', List.of('p', 'q', 'r', 's')),
        Map.entry('8', List.of('t', 'u', 'v')),
        Map.entry('9', List.of('w', 'x', 'y', 'z'))
    );
    
    private List<String> res = new ArrayList<>();
    private StringBuilder combination = new StringBuilder();
    private String digits;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        this.digits = digits;
        backtrack(0);
        return res;
    }

    private void backtrack(int i) {
        if (i == digits.length()) {
            res.add(combination.toString());
            return;
        }

        for (Character c : map.get(digits.charAt(i))) {
            combination.append(c);
            backtrack(i + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}