/*interview test for Goldman 
 * September 19th 2017*/

public class Goldman {
	/*Q1:
	 * input: String with several characters
	 * output:Appear times of a character
	 * example:cccdddeee -> 3c3d3e*/
	static String runLengthEncode(String input) {
        if(input.equals(null)||input.length()==0){
            return null;
        }
        char inputChar[] = input.toCharArray();
        char characters[] =new  char[input.length()];
        int number[] =new  int[input.length()];
        for (int i = 0;i<input.length();i++) {
        	number[i] = 0;
        }
        int index = 0;
        for (int i = 0;i<input.length();i++) {
        	char check = inputChar[i];
        	boolean exists = false;
        	for(int j = 0;j<index;j++) {
        		if(check==characters[j]) {
        			number[j] = number[j] + 1;
        			exists = true;
        			break;
        		}
        	}
        	if(exists == false) {
        		characters[index] = check;
        		index++;
        	}
        }
        String output ="";
        for(int i =0;i<index;i++) {
        	output = output+number[i]+characters[i];
        }
        return output;
    }
	
	/*Q2:
	 * input: a number which is supposed to be the value of sum
	 *              an array of integer
	 * output:number of possible combinations of two integer in the array
	 *                which add together equal sum*/
	static int countPairs(int k, int[] a) {
		 if(a.length==0){
	            return 0;
	        }
	        int number[] =new  int[a.length];
	        int times[]=new  int[a.length];
	        for (int i = 0;i<a.length;i++) {
	        	times[i] = 0;
	        }
	        int index = 0;
	        for (int i = 0;i<a.length;i++) {
	        	int check = a[i];
	        	boolean exists = false;
	        	for(int j = 0;j<index;j++) {
	        		if(check==number[j]) {
	        			times[j] = times[j] + 1;
	        			exists = true;
	        			break;
	        		}
	        	}
	        	if(exists == false) {
	        		number[index] = check;
	        		index++;
	        	}
	        }
	        
	        int output = 0;
	        for(int i=0;i<index;i++) {
	        	if(k%2 == 0&&number[i]==k/2) {
	        		output+=(times[i]-1)*times[i]/2;
	        		continue;
	        	}
	        	for(int j=i;j<index;j++) {
	        		if(number[i]+number[j]==k) {
	        			output+=times[i]*times[j];
	        			continue;
	        		}
	        	}
	        }
	        return output;
    }
}
