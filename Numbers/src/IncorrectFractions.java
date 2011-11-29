import java.util.ArrayList;


public class IncorrectFractions {

	public boolean checkIfWorks(String top, String bottom) {
		if (seeIfLegit(top, bottom))
			return false;
		return false;
	}
	
	private boolean seeIfLegit(String top, String bottom) {
		if ((top.length() == bottom.length()) && (top.length() == 2)) {
			char[] array1 = top.toCharArray();
			char[] array2 = bottom.toCharArray();
			
			if ((array1[0] == array2[1]) ^ (array1[1] == array2[0]))
				return false;
		}
		return true;
	}
	
	private ArrayList<ArrayList<String>> generateArrays() {
		return null;
	}
}