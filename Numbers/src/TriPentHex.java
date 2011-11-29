
public class TriPentHex {

	public static int getTriangle(int n) {
		return ((n * (n + 1)) / 2);
	}
	
	public static boolean isPentagonal(int n) {
		for (int i = 165; i < 1000; i++) 
			if (getTriangle(n) == ((i * (3 * i - 1)) / 2))
				return true;
		return false;	
	}
	
	public static boolean isHexagonal(int n) {
		for (int i = 143; i < 1000; i++)
			if (getTriangle(n) == ((i * (2 * i - 1))))
				return true;
		return false;
	}

	public static int theNumber() {
		int result = 0;
		for (int i = 285; i < 1000000000; i++)
			if ((isHexagonal(getTriangle(i))) && (isPentagonal(getTriangle(i))))
				return result;
		return 0;
	}
	
	public static void main(String[] args) {
		
		System.out.println(theNumber());
	}
}
