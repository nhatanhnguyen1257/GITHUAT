/**
 * @deprecated: 
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:

 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:

 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:

 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 * @author nguyen nhat anh
 * @version 1.0
 *
 */
public class RemoveKdigits {
	
	/**
	 * @deprecated: Check the 3 numbers are created continuously. 
	 * If any number is greater then discard. 
	 * If equal, remove from zero.
	 * To eliminate the zero using the interterm type
	 * 
	 * @param num: number index.
	 * @param k : leng number remote
	 */
	public String removeKdigits(String num, int k) {
		int number_a = 0;
		int number_b = 0;
		String temp = "";
        for (int index = 0; index < num.length() - k; index ++) {
        	number_a = getNumber(index, k, num);
        	number_b = getNumber(index + 1, k, num);
        	if (number_a > number_b) {
        		temp = num.substring( 0, index ) + num.substring(index+ k );
        		return ""+Integer.parseInt(isNullString(temp));
        	}else if (number_b > number_a) {
        		temp = num.substring(0 ,index + 1) + num.substring(index+ k + 1 );
        		return ""+Integer.parseInt(isNullString(temp));
        	}
        }
        temp = num.substring(k);
       return ""+Integer.parseInt(isNullString(temp));
	}
	
	/**
	 * @returns a number that is made up of 3 characters in length
	 * */
	private int getNumber(int index, int k, String num) {
		String temp = "";
		for (int i = index; i < index + k; i++) {
			temp +=num.charAt(i);
		}
		return Integer.parseInt(temp);
	}
	
	/**
	 * If the empty bananas return "0". Else retrun itself;
	 * */
	private String isNullString(String num) {
		return num.length() == 0 ? "0" : num;
	}
	
	public static void main(String []args) {
		RemoveKdigits removeKdigits = new RemoveKdigits();
//		String num1 = "1432219";
//		int k1 = 3;
//		
//		String num1 = "10200";
//		int k1 = 1;
////		
		String num1 = "10";
		int k1 = 2;
		
		System.out.println(removeKdigits.removeKdigits(num1, k1));
	}
	
}
