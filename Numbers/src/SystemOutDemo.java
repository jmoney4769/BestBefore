// System.out demo program
/* Author:  Jared Moore
 * School:  Spaulding High School
 * Project:  Create new output using System.out.print commands
 * Date:  September 24, 2011
 */
public class SystemOutDemo {

	
	public static void main(String[] args) {
		
		String one = "This is ";
		String three = "output ";
		String two = "using printf";
		
		System.out.print("This is output using print (with a newline character for readability)\n");
		System.out.println("\nThis is output using println. Note println produces a new line after\n" +
				"the statement, unlike print, and printf.");
		System.out.printf("\n%s%s%s", one, three, two);
		/* since this does not specify what to output as described in
		 * "just creating new output using the System.out.print 
		 * commands to create a series of new messages,"
		 * I have made messages showing each of the print statements that I have
		 * had experience with.  There was no instruction to make statements from any exercise in the 
		 * book, so I did this :)
		 */
	}

}
