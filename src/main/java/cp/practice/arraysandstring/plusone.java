package cp.practice.arraysandstring;

public class plusone {
	public static int[] plusOne(int[] digits) {
        
		int carry = 1, sum = 0;
		
		for (int i = digits.length -1 ; i >= 0  ; i--) {
			
			sum = digits[i] + carry;
			carry = sum / 10;
			digits[i] = sum % 10;
			
		}
		
		if(carry == 0) return digits;
		else {
			int[] res = new int[digits.length + 1];
			res[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				res[i+1] = digits[i];
			}
			return res;
		}
    }
	
	public static void main(String[] args) {
		int a[] = {0};
		int b[] = plusOne(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
