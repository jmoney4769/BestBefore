
public class ThousandInLetters {

	public static final int one = 3;
	public static final int two = 3;
	public static final int three = 5;
	public static final int four = 4;
	public static final int five = 4;
	public static final int six = 3;
	public static final int seven = 5;
	public static final int eight = 5;
	public static final int nine = 4;
	public static final int ten = 3; //10
	public static final int eleven = 6;
	public static final int twelve = 6;
	public static final int thirteen = 8;
	public static final int fourteen = 8;
	public static final int fifteen = 7;
	public static final int sixteen = 7;
	public static final int seventeen = 9;
	public static final int eighteen = 8;
	public static final int nineteen = 8; 
	public static final int twenty = 6; //10
	public static final int thirty = 6; //10
	public static final int fourty = 6; //10
	public static final int fifty = 5; //10
	public static final int sixty = 5; //10
	public static final int seventy = 7; //10
	public static final int eighty = 6; //10
	public static final int ninety = 6; //10
	public static final int hundredAnd = 10; //891
	public static final int thousand = 8;
	public static final int hundred = 7;
	
	public static void main(String[] args) {
		
		String ones = "onetwothreefourfivesixseveneightnine";
		String teens = "eleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
		String tens = "tentwentythirtyfourtyfiftysixtyseventyeightyninety";
		String hundreds = "hundred";
		String and = "and";
		String oneThousand = "onethousand";
		String endOnes = "";
		String endTens = "";
		String endTeens = "";
		String endHundreds = "";
		String endAnd = "";
		
		for (int i = 1; i <= 91; i++)
			endOnes += ones;
		for (int i = 1; i <= 10; i++) {
			endTens += tens;
			endTeens += teens;
			if (i <= 9)
				endHundreds += hundreds;
		}
		for (int i = 1; i <= 891; i++) {
			endAnd += and;
			endHundreds += hundreds;
		}
		String end = endOnes + endTens + endTeens + endHundreds + endAnd + oneThousand;
		
		System.out.println(end.length());
		
		int result = (hundredAnd * 891) + (ninety * 10) + (eighty * 10) + (seventy * 10) + (sixty * 10)
				+ (fifty * 10) + (fourty * 10) + (thirty * 10) + (twenty * 10) + (nineteen * 10) + 
				(eighteen * 10)	+ (seventeen * 10) + (sixteen * 10) + (fifteen * 10) + (fourteen * 10)
				+ (thirteen * 10) + (twelve * 10) + (eleven * 10) + (ten * 10) + (nine * 91) + (eight * 91)
				+ (seven * 91) + (six * 91) + (five * 91) +	(four * 91) + (three * 91) + (two * 91)
				+ (one * 91) + (thousand) + (hundred * 9);
		System.out.println(result);
	}
}
