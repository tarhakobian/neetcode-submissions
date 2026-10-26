class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] occ = new int[26];
            for(Character c : s.toCharArray()){
                occ[c - 'a']++;
            }
            String key = Arrays.toString(occ);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else{
                map.put(key, new ArrayList<>(Arrays.asList(s)));
            }
        }
        return new ArrayList<>(map.values());
    }
}
