import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BubbleSortDriver {
//Driver class that creates a BubbleSort object and Bubble Sorts an array of integers	
	public static void main(String[] args) throws IOException {

		long t1;
		long t2;
		long t3;
		long t4;

		t1 = System.nanoTime();

		BubbleSort sort = new BubbleSort();

		sort.readFile("r100.txt");

		t2 = System.nanoTime();

		sort.bubbleSort();

		t3 = System.nanoTime();

		Writer fileWriter = new BufferedWriter(new FileWriter("out.txt"));
		fileWriter.append(sort.printValues() + System.getProperty("line.separator"));
		fileWriter.append(sort.searchIndex + "th largest is " + sort.values[sort.searchIndex - 1]
				+ System.getProperty("line.separator"));

		t4 = System.nanoTime();

		fileWriter.append(
				"CPU time used during input = " + (t2 - t1) + " nanoseconds" + System.getProperty("line.separator"));
		fileWriter.append("CPU time used during calculations = " + (t3 - t2) + " nanoseconds"
				+ System.getProperty("line.separator"));
		fileWriter.append(
				"CPU time used during output = " + (t4 - t3) + " nanoseconds" + System.getProperty("line.separator"));
		fileWriter.flush();
		fileWriter.close();

	}

}
