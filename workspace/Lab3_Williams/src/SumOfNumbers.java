import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class SumOfNumbers {

	static int size;
	static int[] values;
	static int[] backupValues;
	static int k;

	public SumOfNumbers(int size, int k) {
		this.size = size;
		this.values = new int[size];
		this.k = k;
	}

	public String toString(long algorithm1Time, long algorithm2Time, Vector<?> algo1Results, Vector<?> algo2Results) {
		String s = new String();

		DecimalFormat formatter = new DecimalFormat("0.000E0");

		s += k + "\n";
		s += "Before heap sort\n";
		s += "SumOfK\n";
		s += java.util.Arrays.toString(backupValues).replace("[", "").replaceAll("]", "").replace(",", "") + "\n";
		s += "Algorithm1 calculation only O(n^2)\n";

		if ((boolean) algo1Results.get(0)) {
			s += ("Yes\n");
			s += algo1Results.get(1) + "+" + algo1Results.get(2) + "=" + algo1Results.get(3) + "\n";
		} else {
			s += "No\n";
		}

		s += "Algorithm1: " + formatter.format(algorithm1Time).toLowerCase() + " nanoseconds,\n";

		return s;
	}

	public void initValues(ArrayList<String> data) {
		int index = 0;
		for (int i = 2; i < data.size(); i++) {
			values[index] = Integer.parseInt(data.get(i));
			index++;
		}

		backupValues = values.clone();
	}

	public void resetValues() {
		values = backupValues.clone();
	}

	// O(N^2) operation
	public Vector algorithm1() {

		Vector results = new Vector();
		boolean sumExists = false;

		for (int i = 0; i < values.length; i++) {

			int firstNum = values[i];
			int secondNum = 0;

			// condition for checking the value of the current index plus itself
			if (values[i] * 2 == k) {
				secondNum = firstNum;
				sumExists = true;
				break;
			}

			// condition for checking the value of current index plus the remaining values
			// in the array
			else {
				for (int j = i; j < values.length; j++) {
					if (values[i] + values[j] == k) {
						secondNum = values[j];
						sumExists = true;
						break;
					}
				}
			}

			if (sumExists) {
				results.add(sumExists);
				results.add(firstNum);
				results.add(secondNum);
				results.add(firstNum + secondNum);

				break;
			}
		}

		if (!sumExists) {
			results.add(sumExists);
		}

		return results;
	}

	public Vector algorithm2() {

		System.out.println("In algo2");

		Vector results = new Vector();

		int lastIndex = values.length - 1;

		for (int i = 0; i < values.length; i++) {
			if (values[lastIndex] > k) {
				System.out.println(values[lastIndex] + " > " + k);
				lastIndex--;
			}

			if (values[i] + values[lastIndex] == k) {
				System.out.println(values[i] + "+" + values[lastIndex] + " = " + (values[i] + values[lastIndex]));
				results.add(true);
				results.add(values[i]);
				results.add(values[lastIndex]);
				results.add(values[i] + values[lastIndex]);
				break;
			} else {
				lastIndex--;
			}
		}
		return results;
	}

	// swap values in array
	public void swapValues(int firstIndex, int secondIndex) {

		int swapValue = values[firstIndex];
		values[firstIndex] = values[secondIndex];
		values[secondIndex] = swapValue;

	}

	// get the location where the element should be moved to in the heap
	public int getNewNode(int currentNode, int index, int value) {

		int leftChild = (currentNode * 2) + 1;
		int rightChild = (currentNode * 2) + 2;

		if (leftChild > index) {
			return currentNode;
		}

		else if (leftChild == index) {
			if (values[leftChild] > value) {
				return leftChild;
			} else {
				return currentNode;
			}
		} else if (values[rightChild] > values[leftChild]) {
			if (value >= values[rightChild]) {
				return currentNode;
			} else {
				return rightChild;
			}
		} else if (value >= values[leftChild]) {
			return currentNode;
		} else {
			return leftChild;
		}

	}

	// build the heap
	public void buildHeap(int value, int root, int index) {

		int currentNode = root;
		int newNode;

		newNode = getNewNode(currentNode, index, value);
		while (newNode != currentNode) {
			values[currentNode] = values[newNode];
			currentNode = newNode;
			newNode = getNewNode(currentNode, index, value);
		}
		values[currentNode] = value;

	}

	// Heap Sort is an O(N log(N)) algorithm
	public void heapSort() {

		int i;

		for (i = size / 2 - 1; i >= 0; i--)
			buildHeap(values[i], i, size - 1);

		// Sort the array.
		for (i = size - 1; i >= 1; i--) {
			swapValues(0, i);
			buildHeap(values[0], 0, i - 1);
		}
	}

}
