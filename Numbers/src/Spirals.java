public class Spirals {

	public static long calcTotal(int numOfSprials) {
		long result = 0;
		for (int i = 3; i <= numOfSprials; i += 2) {
			result += (long) ((4 * Math.pow(i, 2)) - (6 * i) + 6);
		}
		result++;
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(calcTotal(1001));
	}
}
