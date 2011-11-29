import java.math.BigInteger;
import java.util.ArrayList;

public class Numbers {	
	
	public static ArrayList<BigInteger> array = new ArrayList<BigInteger>();
	
	public static BigInteger findNext(BigInteger whichOne) {		
	
		return whichOne.multiply(whichOne.add(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE));
	}
	
	public static void main(String[] args) {
		
		BigInteger tester = BigInteger.ONE;
		BigInteger triangle = Numbers.findNext(tester);
		do {
			tester = tester.add(BigInteger.ONE);
			triangle = Numbers.findNext(tester);	
		}
		while (Numbers.findNumOfDivisors(triangle).compareTo(new BigInteger("500")) <= 0);
		System.out.println(Numbers.findNext(tester));
	}
	
	public static BigInteger findNumOfDivisors(BigInteger triangle) {
	
		BigInteger nod = BigInteger.ONE;
		BigInteger exponent;
		
		return null;
		
	}
	
}
