package cp.practice;

public class permutation {

	static int count = 0;
	
	public static void main(String[] args) {
		permutations("slot","");
		System.out.println(count);
	}

	private static void permutations(String string, String prefix) {
		if(string.contentEquals("")) {
			System.out.println(prefix);
			count++;
		}
		
		for (int i = 0; i < string.length(); i++) {
			String rem = string.substring(0,i)+string.substring(i+1);
			permutations(rem,prefix+string.charAt(i));
		}
		
	}
	
	
}
