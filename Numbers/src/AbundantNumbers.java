public class AbundantNumbers {	
	
	public static boolean isAbundant(int triangle) {		
		
		int result = 0;
		for (int i = 1; i < (triangle / 2); i ++) {
			if (triangle % i == 0)
				result++;
		}		
		int[] array = new int[result];
		int current = 0;
		
		for (int i = 1; i < (triangle / 2); i ++) {
			if (triangle % i == 0) {
				array[current] = i;
				current++;
			}
		}
		
		int totalOfFactors = 0;
		
		for (int i = 0; i < array.length; i++) {
			totalOfFactors += array[i];
		}
		
		if (totalOfFactors > triangle)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		
		int firstLength = 0;
		for (int i = 12; i <= 28123; i++) {
			if (AbundantNumbers.isAbundant(i))
				firstLength++;
		}
		int[] array = new int[firstLength];
		
		for (int i = 12; i <= 28123; i++) {
			int counter = 0;
			if (AbundantNumbers.isAbundant(i)) {
				array[counter] = i;
				counter++;
			}
		}
		System.out.println(array[2561]);
	}

}
