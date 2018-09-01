import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

/**
 * Purpose: The PolynomialDriver class executes the Polynomial class. It reads
 * an input file and calls each of the methods within the Polynomial class to
 * calculate the polynomial value using three different algorithms. It writes
 * the results to an output file.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-09-01
 * 
 */

public class PolynomialDriver {

	public static void main(String[] args) throws IOException {

		FileReader.readFile("r5.txt");

		Vector v = new Vector();
		Vector results = new Vector();
		String coefficients = new String();

		for (int i = 1; i <= FileReader.data.size() - 1; i++) {
			v.add(FileReader.data.get(i));
			coefficients += String.format("%.0f", FileReader.data.get(i)) + " ";
		}

		Polynomial p = new Polynomial(FileReader.data.get(0), FileReader.data.size() - 2, v);
		
		WriteFile outFile = new WriteFile("out.txt");
		outFile.writeLine(String.format("%.0f", FileReader.data.get(0)));
		outFile.writeLine(coefficients.trim());
		
		results = p.algorithmOne();
		
		outFile.writeLine(("Algorithm1: => p(" + String.format("%.0f", FileReader.data.get(0)) + ") ="
				+ String.format("%.0f", results.get(0)) + ", " + results.get(2) + " nanoseconds, "
				+ results.get(1) + " +- operations, " +results.get(1) + " *operations, "
				+ results.get(1) + " pow function calls"));
		
		results.clear();
		
		results = p.algorithmTwo();
		
		outFile.writeLine(("Algorithm2: => p(" + String.format("%.0f", FileReader.data.get(0)) + ") ="
				+ String.format("%.0f", results.get(0)) + ", " + results.get(2) + " nanoseconds, "
				+ results.get(1) + " +- operations, " +results.get(1) + " *operations, "
				+ results.get(1) + " pow function calls"));
		
		results.clear();
		
		results = p.hornersRule();
		
		outFile.writeLine(("Algorithm3: => p(" + String.format("%.0f", FileReader.data.get(0)) + ") ="
				+ String.format("%.0f", results.get(0)) + ", " + results.get(2) + " nanoseconds, "
				+ results.get(1) + " +- operations, " +results.get(1) + " *operations"));
		
		outFile.closeFile();
	}

}
