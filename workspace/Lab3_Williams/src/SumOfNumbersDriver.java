import java.io.IOException;
import java.util.Vector;

/**
 * Purpose: The SumOFNumbersDriver class is a driver program that executes the
 * methods within the SumOfNumbers class. It reads input files and processes the
 * data through the algorithms in SumOfNumbers. It then writes the results to
 * output files.
 * 
 * Constructors: none
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-09-13
 * 
 */

public class SumOfNumbersDriver {

	public static void main(String[] args) throws IOException {

		// declare variables
		long algorithm1Time, algorithm2Time, startTime, endTime;
		Vector<Object> algo1Results = new Vector<Object>();
		Vector<Object> algo2Results = new Vector<Object>();
		String inFileName = new String();
		String outFileName = new String();

		try {
			// Read the file
			for (int i = 1; i < 5; i++) {
				inFileName = i + "_in.txt";
				FileReader file = new FileReader(inFileName);

				file.readFile();

				// create instance of SumOfNumbers
				SumOfNumbers s1 = new SumOfNumbers(file.data.size() - 2, Integer.parseInt(file.data.get(1)));

				// initialize array
				s1.initValues(file.data);

				// run first algoritm
				startTime = System.nanoTime();
				algo1Results = (Vector<Object>) s1.algorithm1().clone();
				endTime = System.nanoTime();

				algorithm1Time = endTime - startTime;

				// reset the array and results
				s1.resetValues();

				// run the heap sort and algorithm2
				startTime = System.nanoTime();
				s1.heapSort();
				algo2Results = (Vector<Object>) s1.algorithm2(0, s1.values.length - 1).clone();
				endTime = System.nanoTime();

				algorithm2Time = endTime - startTime;

				// print the file
				try {
					outFileName = i + "_out.txt";
					WriteFile writer = new WriteFile(outFileName);
					writer.writeLine(s1.print(algorithm1Time, algorithm2Time, algo1Results, algo2Results));
					writer.closeFile();
				} catch (IOException e) {
					System.out.println("Could not create output file " + outFileName + ".");
				}

			}
		} catch (IOException e) {
			System.out.println("File " + inFileName + " not found. Exiting program.");
		}
	}
}
