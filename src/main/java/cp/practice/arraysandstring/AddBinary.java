package cp.practice.arraysandstring;

public class AddBinary {

	public String addBinary(String a, String b) {
        if(a.length() > b.length()) return addBinary(b, a);
        
        StringBuilder s = new StringBuilder();
        
        char ac, bc, c = '0';
        
        for (int i = 0, j =0; j < b.length(); i++, j++) {
			ac = i == a.length() ? '0': a.charAt(i);
			bc = b.charAt(j);
		}
        return null;
    }
}
