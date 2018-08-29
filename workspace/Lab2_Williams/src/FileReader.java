import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

	static ArrayList<Double> data;
	static String fileName;

	FileReader(String fileName) {
		this.fileName = fileName;
	}

	static void readFile(String fileName) throws FileNotFoundException {
		// Reads a file and loads the values into an array list

		data = new ArrayList<Double>();

		Scanner scanner = new Scanner(new File(fileName));

		while (scanner.hasNextLine()) {
			if (scanner.hasNext()) {
				data.add((double) scanner.nextInt());
			} else {
				break;
			}
		}

		scanner.close();

	}

}
