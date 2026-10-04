class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int base = 0;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                base += customers[i];
            }
        }

        
        int cont = 0;
        for(int i = 0; i < minutes; i++){
            if(grumpy[i] == 1) cont+= customers[i];
        }
        int maxCont = cont;

        for(int i = minutes; i < n; i++){
            if(grumpy[i] == 1) cont += customers[i];
            if(grumpy[i - minutes] == 1) cont -= customers[i - minutes];

            maxCont = Math.max(maxCont, cont);
        }

        return base + maxCont;
    }
}