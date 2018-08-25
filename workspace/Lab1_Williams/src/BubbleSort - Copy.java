import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

	static int size;
	static int searchIndex;
	static int[] values;
	static long t1;
	static long t2;
	static long t3;
	static long t4;

	BubbleSort(int size, int searchIndex) {
		this.size = size;
		this.searchIndex = searchIndex;
		values = new int[size];
	}

	static public String printValues()
	// Prints all the values integers.
	{
		int value;
		String string = new String();
		for (int index = 0; index < size; index++) {
			value = values[index];
			string += value + " ";

		}

		return string;

	}

	static public void swap(int index1, int index2)
	// Precondition: index1 and index2 are >= 0 and < SIZE.
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	static void bubbleUp(int startIndex, int endIndex)
	// Switches adjacent pairs that are out of order
	// between values[startIndex]..values[endIndex]
	// beginning at values[endIndex].
	{
		for (int index = endIndex; index > startIndex; index--) {
			if (values[index] > values[index - 1]) {
				swap(index, index - 1);
			}
		}
	}

	static void bubbleSort()
	// Sorts the values array using the bubble sort algorithm.
	{
		int current = 0;

		while (current < (size - 1)) {
			bubbleUp(current, size - 1);
			current++;
		}
	}

	static void readFile(String fileName) throws FileNotFoundException {
		ArrayList<Integer> data = new ArrayList<Integer>();

		Scanner scanner = new Scanner(new File(fileName));

		t1 = System.nanoTime();
		while (scanner.hasNextLine()) {
			if (scanner.hasNext()) {
				data.add(scanner.nextInt());
			}
		}

		scanner.close();

		BubbleSort sort = new BubbleSort(data.get(0), data.get(1));

		values = new int[data.get(0)];
		searchIndex = data.get(1);

		for (int i = 0; i < data.size() - 2; i++) {
			values[i] = data.get(i + 2);
		}

	}

	public static void main(String[] args) throws IOException {

		t1 = System.nanoTime();

		readFile("in.txt");

		t2 = System.nanoTime();

		bubbleSort();

		t3 = System.nanoTime();

		Writer fileWriter = new BufferedWriter(new FileWriter("out.txt"));
		fileWriter.append(printValues() + System.getProperty("line.separator"));
		fileWriter.append(
				searchIndex + "th largest is " + values[searchIndex - 1] + System.getProperty("line.separator"));

		t4 = System.nanoTime();

		fileWriter.append(
				"CPU time used during input = " + (t2 - t1) + " nanoseconds" + System.getProperty("line.separator"));
		fileWriter.append("CPU time used during calculations = " + (t3 - t2) + " nanoseconds"
				+ System.getProperty("line.separator"));
		fileWriter.append(
				"CPU time used during output = " + (t4 - t3) + " nanoseconds" + System.getProperty("line.separator"));
		fileWriter.close();

	}

}
