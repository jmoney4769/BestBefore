import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class TextFileInputValueTest {

	private TextFileInputValue object = new TextFileInputValue();
	@Test
	public void testGetValues() {
		String[] list = {"THE", "QUICK", "BROWN", "FOX", "JUMPED", "OVER", "THE", "LAZY", "DOGS"};
		ArrayList<String> array = new ArrayList<String>(Arrays.asList(list));
		assertEquals(482, object.getValues(array));
	}
	
	@Test
	public void testGetWordResult() {
		
		char[] test = new String("THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOGS").toCharArray();
		assertEquals(482, object.getWordResult(test));
	}

}
