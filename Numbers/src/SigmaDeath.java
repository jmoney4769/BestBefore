import java.math.BigInteger;


public class SigmaDeath {

	public static void main(String[] args) {
		BigInteger number = BigInteger.ZERO;
		
		for (int i = 1; i <= 30; i++) {
			BigInteger temp = new BigInteger(Integer.toString(i));
			number = number.add(temp.pow(987654321));
		}
		System.out.println(number);
	}
}
