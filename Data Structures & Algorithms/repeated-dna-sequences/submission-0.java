class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();

        Map<String, Integer> occ = new HashMap<>();

        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        occ.put(sb.toString(), 1);

        for(int i = 10; i < s.length(); i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String newS = sb.toString();
            occ.put(newS, occ.getOrDefault(newS, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> e : occ.entrySet()){
            if(e.getValue() >= 2){
                res.add(e.getKey());
            }
        }

        return res;
    }
}
