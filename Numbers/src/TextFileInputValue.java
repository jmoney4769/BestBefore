import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TextFileInputValue {

	private BufferedReader reader;
	private ArrayList<String> array;
	
	public TextFileInputValue() {
		
		setUpArray("res/words.txt");
		System.out.println(getNumberOfTriangles(array));
	}
	
	private void getFile(String path) {
		
		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(
					path)); //file path will vary, I included in /res folder of project
			reader = new BufferedReader(inReader);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void setUpArray(String path) {
		
		try {
			getFile(path);
			String line = reader.readLine();
			String[] stringArray = line.split(" ");
			array = new ArrayList<String>(Arrays.asList(stringArray));
			Collections.sort(array);
		}
		catch (IOException e) {
			e.printStackTrace();			
		}
	}
	
	public int getValues(ArrayList<String> array) {
		
		int result = 0;
		for (int i = 0; i < array.size(); i++) {
			char[] local = array.get(i).toCharArray();
			result += (getWordResult(local) * (i + 1));			
		}
		return result;
	}
	
	public int getNumberOfTriangles(ArrayList<String> array) {
		int result = 0;
		for (int i = 0; i < array.size(); i++) {
			char[] local = array.get(i).toCharArray();
			int value = getWordResult(local);
			if (isTriangle(value))
				result++;			
		}
		return result;
	}

	private boolean isTriangle(int value) {
		for (int i = 1; i < 25; i++) 
			if (((i * (i + 1)) / 2) == value)
				return true;
		return false;
	}

	protected int getWordResult(char[] local) {
		
		int wordResult = 0;
		for (int j = 0; j < local.length; j++) {
		if (local[j] == 'A')
			wordResult += 1;
		else if (local[j] == 'B')
			wordResult += 2;
		else if (local[j] == 'C')
			wordResult += 3;
		else if (local[j] == 'D')
			wordResult += 4;
		else if (local[j] == 'E')
			wordResult += 5;
		else if (local[j] == 'F')
			wordResult += 6;
		else if (local[j] == 'G')
			wordResult += 7;
		else if (local[j] == 'H')
			wordResult += 8;
		else if (local[j] == 'I')
			wordResult += 9;
		else if (local[j] == 'J')
			wordResult += 10;
		else if (local[j] == 'K')
			wordResult += 11;
		else if (local[j] == 'L')
			wordResult += 12;
		else if (local[j] == 'M')
			wordResult += 13;
		else if (local[j] == 'N')
			wordResult += 14;
		else if (local[j] == 'O')
			wordResult += 15;
		else if (local[j] == 'P')
			wordResult += 16;
		else if (local[j] == 'Q')
			wordResult += 17;
		else if (local[j] == 'R')
			wordResult += 18;
		else if (local[j] == 'S')
			wordResult += 19;
		else if (local[j] == 'T')
			wordResult += 20;
		else if (local[j] == 'U')
			wordResult += 21;
		else if (local[j] == 'V')
			wordResult += 22;
		else if (local[j] == 'W')
			wordResult += 23;
		else if (local[j] == 'X')
			wordResult += 24;
		else if (local[j] == 'Y')
			wordResult += 25;
		else if (local[j] == 'Z')
			wordResult += 26;
		}
		return wordResult;
	}
	
	public static void main(String[] args) {
		
		TextFileInputValue here = new TextFileInputValue();
	}
}
