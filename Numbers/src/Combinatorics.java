import java.math.BigInteger;


public class Combinatorics {
	
	public static BigInteger permutations(BigInteger totalSpots, BigInteger spotTakers) { // order matters
		
		BigInteger result = factorial(totalSpots).divide(factorial(totalSpots.subtract(spotTakers)));
		return result;
	}
	
	public static BigInteger combinations(BigInteger totalSpots, BigInteger spotTakers) { // order does not matter
		
		BigInteger result = (permutations(totalSpots, spotTakers).divide(factorial(spotTakers)));
		return result;
	}
	
	public static BigInteger factorial(BigInteger number) {
		BigInteger total = new BigInteger("1");
		String n = number.toString();
		for (Integer i = Integer.parseInt(n); i > 0; i--) {
			String j = i.toString();
			total = total.multiply(new BigInteger(j));
		}
		return total;
	}
}
