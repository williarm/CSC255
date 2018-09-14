import java.io.IOException;
import java.util.Vector;

public class SumOfNumbersDriver {

	public static void main(String[] args) throws IOException {

		// declare variables
		long algorithm1Time, algorithm2Time, startTime, endTime;
		Vector<Object> algo1Results = new Vector<Object>();
		Vector<Object> algo2Results = new Vector<Object>();

		// Read the file
		try {
			FileReader file = new FileReader("1_in.txt");

			file.readFile();

			// create instance of SumOfNumbers
			SumOfNumbers s1 = new SumOfNumbers(file.data.size() - 2, Integer.parseInt(file.data.get(1)));

			// initialize array
			s1.initValues(file.data);

			// run first algoritm
			startTime = System.nanoTime();
			algo1Results = s1.algorithm1();
			endTime = System.nanoTime();

			algorithm1Time = endTime - startTime;

			// reset the array
			s1.resetValues();

			// run the heap sort
			startTime = System.nanoTime();
			s1.heapSort();
			algo2Results = s1.algorithm2();
			endTime = System.nanoTime();
			algorithm2Time = endTime - startTime;

			//System.out.println(s1.toString(algorithm1Time, algorithm2Time, algo1Results, algo2Results));

		} catch (Exception e) {
			System.out.println("File not found. Exiting program.");
		}
	}
}
