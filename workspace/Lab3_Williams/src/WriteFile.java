import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Purpose: The WriteFile class is designed to create an output file
 * and write to the file.
 * 
 * Constructors: WriteFile
 * 
 * Methods: writeLine, closeFile
 * 
 * @author Robert Williams
 * @since 2018-09-01
 * 
 */

public class WriteFile {

	Writer fileWriter;

	WriteFile(String fileName) throws IOException {
		this.fileWriter = new BufferedWriter(new FileWriter(fileName));
	}

	public void writeLine(String string) throws IOException {
		fileWriter.append(string);

	}

	public void closeFile() throws IOException {
		fileWriter.flush();
		fileWriter.close();
	}

}
