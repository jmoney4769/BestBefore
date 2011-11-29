import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class Fibonacci {
	
	private static final BigDecimal ONE = BigDecimal.ONE;
	private static final BigDecimal TWO = new BigDecimal("2");
	protected static final BigDecimal FIVE = new BigDecimal(Math.sqrt(5));
	public static BigInteger[] array = {BigInteger.ZERO , BigInteger.ZERO};
	
	public static BigDecimal linearFibonacci(int num) {
		BigDecimal fract = new BigDecimal(1/Math.sqrt(5));
		BigDecimal result = (fract.multiply(((ONE.add(FIVE)).divide(TWO)).pow(num)))
				.subtract(fract.multiply(((ONE.add(FIVE)).divide(TWO)).pow(num)));
		return result;
	}
	

	public static BigInteger fibonacci(BigInteger number) {
				
		ArrayList<BigInteger> array = new ArrayList<BigInteger>();
		if (array.size() < 2) {
			array.add(number);
			return BigInteger.ONE;
		}
		BigInteger result = number.add(array.get(array.size() - 1).add(array.get(array.size() - 2)));
		array.add(number);
		
		return result;
	}
	
	public static BigInteger fibonacciArray(BigInteger next) {
		
		if (array[1] == BigInteger.ZERO) { 
			if (array[0] == BigInteger.ZERO)
				array[0] = BigInteger.ONE;
			else
				array[1] = BigInteger.ONE;
			return BigInteger.ONE;
		}
		BigInteger result = array[0].add(array[1]);
		array[0] = array[1];
		array[1] = result;
		return result;
	}
	public static void main(String[] args) {
		
		BigInteger tester = new BigInteger("1");
		int length = fibonacciArray(tester).toString().length();
		while (length < 1000) {
			tester = tester.add(BigInteger.ONE);
			length = fibonacciArray(tester).toString().length();
			System.out.println(tester + " " + length);
		}
		System.out.println(tester);
	}
	
}
