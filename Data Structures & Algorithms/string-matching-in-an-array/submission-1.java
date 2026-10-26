class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String>res=new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i==j)continue;
                if(words[i].contains(words[j])){
                    res.add(words[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}