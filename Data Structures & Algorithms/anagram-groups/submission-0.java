class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];
            for(Character c : s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }

        return new ArrayList<>(map.values());
    }
}
