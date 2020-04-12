package cp.practice.leetcode30day.laststoneweight;

class Solution {
    public static int lastStoneWeight(int[] stones) {
     
    	int h1 =0,h2=0,h1pos,h2pos, f=0;
    	
    	while(f==0){
    		
    		h1=0;h1pos=0;
    		h2=0;h2pos=0;
    		for (int i = 0; i < stones.length; i++) {
				if(stones[i]>= h1) {h2=h1;h2pos=h1pos;h1 = stones[i];h1pos=i;}
				else if(stones[i]>= h2) {h2=stones[i];h2pos=i;}
			}
    		
    		if(h1==0 || h2 == 0) {
    			f=1;
    		}	
    		else {
    			stones[h1pos] = stones[h1pos]-stones[h2pos];
    			stones[h2pos] = 0;
    		}
    	}

    	return Math.max(h1, h2);
    }
    
    public static void main(String[] args) {
    	int a[] = {2,2};
    	System.out.println(lastStoneWeight(a));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}