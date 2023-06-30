import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
			Arrays.sort(items, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
               return (b.value*a.weight - b.weight * a.value);
            }});

			double ans = 0;
			for(int i=0; i<n; i++){
				if(w >= items[i].weight){
					ans += items[i].value;
					w -= items[i].weight;
				}else{
					ans += (double)items[i].value*w/(double)items[i].weight;
					break;
				}
			}

			return ans;
    }
}
