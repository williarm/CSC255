import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
//Implements the BubbleSort algorithm

	int size;
	int searchIndex;
	int[] values;

	public String printValues()
	// Returns a string with the ordered value integers
	{
		int value;
		String string = new String();
		for (int index = 0; index < size; index++) {
			value = values[index];
			string += value + " ";

		}

		return string;

	}

	public void swapValues(int index1, int index2)
	// Swaps the values at index1 and index2 of the values array
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	public void bubbleUp(int startIndex, int endIndex)
	// Bubbles up values that are out of order from smallest to largest
	{
		for (int index = endIndex; index > startIndex; index--) {
			if (values[index] > values[index - 1]) {
				swapValues(index, index - 1);
			}
		}
	}

	public void bubbleSort()
	// Sorts the values array using the bubble sort algorithm.
	{
		int currentIndex = 0;

		while (currentIndex < (size - 1)) {
			bubbleUp(currentIndex, size - 1);
			currentIndex++;
		}
	}

	public void readFile(String fileName) throws FileNotFoundException {
		// Reads a file and loads the values into an array list

		ArrayList<Integer> data = new ArrayList<Integer>();

		Scanner scanner = new Scanner(new File(fileName));

		while (scanner.hasNextLine()) {
			if (scanner.hasNext()) {
				data.add(scanner.nextInt());
			}
		}

		scanner.close();

		size = data.get(0);

		values = new int[size];
		searchIndex = data.get(1);

		for (int i = 0; i < data.size() - 2; i++) {
			values[i] = data.get(i + 2);
		}

	}

}
