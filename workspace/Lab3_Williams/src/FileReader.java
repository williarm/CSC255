import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Purpose: The FileReader class is designed to read an input file and store the
 * data in an ArrayList.
 * 
 * Constructors: FileReader
 * 
 * Methods: readFile
 * 
 * @author Robert Williams
 * @since 2018-09-01
 * 
 */

public class FileReader {

	ArrayList<String> data;
	String fileName;

	FileReader(String fileName) {
		this.fileName = fileName;
	}

	void readFile() throws FileNotFoundException {
		// Reads a file and loads the values into an array list

		data = new ArrayList<String>();

		Scanner scanner = new Scanner(new File(fileName));

		while (scanner.hasNextLine()) {
			if (scanner.hasNext()) {
				data.add(scanner.next());
			} else {
				break;
			}
		}

		scanner.close();

	}

}
