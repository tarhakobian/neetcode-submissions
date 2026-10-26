public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = timestamp.length;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new int[]{timestamp[i], i});
        arr.sort((a, b) -> Integer.compare(a[0], b[0]));

        Map<String, List<String>> mp = new HashMap<>();
        for (int[] p : arr) {
            int idx = p[1];
            mp.computeIfAbsent(username[idx], k -> new ArrayList<>()).add(website[idx]);
        }

        Map<String, Integer> count = new HashMap<>();
        for (String user : mp.keySet()) {
            List<String> cur = mp.get(user);
            Set<String> patterns = new HashSet<>();
            for (int i = 0; i < cur.size(); i++)
                for (int j = i + 1; j < cur.size(); j++)
                    for (int k = j + 1; k < cur.size(); k++)
                        patterns.add(cur.get(i) + "#" + cur.get(j) + "#" + cur.get(k));
            for (String p : patterns)
                count.put(p, count.getOrDefault(p, 0) + 1);
        }

        String res = "";
        int max_count = 0;
        for (String p : count.keySet()) {
            int c = count.get(p);
            if (c > max_count || (c == max_count && p.compareTo(res) < 0)) {
                max_count = c;
                res = p;
            }
        }
        return Arrays.asList(res.split("#"));
    }
}