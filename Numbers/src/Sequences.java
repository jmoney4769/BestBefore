
public class Sequences {

	public static long determineNumber(long start) {
		long result = 0;
		
		while (start != 1) {
			start = doStuff(start);
			result++;
		}
		return result;
	}

	private static long doStuff(long start) {
		if (start % 2 == 0)
			start /= 2;
		else 
			start = start * 3 + 1;
		return start;
	}
	
	public static void main(String[] args) {
		
		long totalTimes = 0;
		long value = 0;
		for (long i = 999999; i > 0; i--) {
			if (Sequences.determineNumber(i) > totalTimes) {
				totalTimes = Sequences.determineNumber(i);
				value = i;
			}
		}
		System.out.println(value);
	}
}
