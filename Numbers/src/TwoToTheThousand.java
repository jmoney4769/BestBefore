//small program designed to solve problems 16 and 20 of Project Euler
//Author: Jared Moore
import java.math.BigInteger;


public class TwoToTheThousand {
	
	public static BigInteger calcNum() {
		BigInteger var = new BigInteger("2");
		var = var.pow(1000);
		return var;
	}
	public static void main(String[] args) {
		BigInteger total = TwoToTheThousand.calcNum();
		BigInteger total2 = Combinatorics.factorial(new BigInteger("100")); //see the Combinatorics.java file for info on this line
		char[] array2 = total2.toString().toCharArray();
		String test = total.toString();
		char[] array = test.toCharArray();
		BigInteger result = BigInteger.ZERO;
		BigInteger result2 = BigInteger.ZERO;
		
		for (int i = 0; i < array2.length; i++) {
			result2 = result2.add(new BigInteger(Character.toString(array2[i])));
		}

		for (int i = 0; i < array.length; i++) {
			result = result.add(new BigInteger(Character.toString(array[i])));
		}
		System.out.println(result + " " + result2);
	}
}
