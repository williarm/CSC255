import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class SumOfNumbers {

	static int size;
	static int[] values;
	static int[] backupValues;
	static int k;
	static Vector results;

	// constructor
	public SumOfNumbers(int size, int k) {
		this.size = size;
		this.values = new int[size];
		this.k = k;
		this.results = new Vector();
	}

	// print the output
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

		s += "Algorithm2 includes build heap and heap sort O(nlog(n))\n";
		s += "Calculation itself in Algorithm2 O(n)\n";

		if ((boolean) algo2Results.get(0)) {
			s += ("Yes\n");
			s += algo2Results.get(1) + "+" + algo2Results.get(2) + "=" + algo2Results.get(3) + "\n";
		} else {
			s += "No\n";
		}

		s += "Algorithm1: " + formatter.format(algorithm1Time).toLowerCase() + " nanoseconds,\n";
		s += "Algorithm2: " + formatter.format(algorithm2Time).toLowerCase() + " nanoseconds,\n";

		return s;
	}

	// initialize the values array
	public void initValues(ArrayList<String> data) {
		int index = 0;
		for (int i = 2; i < data.size(); i++) {
			values[index] = Integer.parseInt(data.get(i));
			index++;
		}

		backupValues = values.clone();
	}

	// reset the values array to unordered
	public void resetValues() {
		values = backupValues.clone();
		results.clear();
	}

	// O(N^2) operation
	// for each record in the values array, check two conditions:
	// 1 - is the value times 2 equal to k
	// 2 - is the value plus each of the remaining values equal to k
	public Vector algorithm1() {

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

	public Vector algorithm2(int firstIndex, int lastIndex) {

		int currentSum = values[firstIndex] + values[lastIndex];

		// base case, exit if the sum equals k
		if (currentSum == k) {
			results.add(true);
			results.add(values[firstIndex]);
			results.add(values[lastIndex]);
			results.add(currentSum);
			return results;
		} else {
			// if p1 = p2 and then check if sum is not equal to k
			if ((firstIndex == lastIndex) && (currentSum != k)) {
				results.add(false);
				return results;
			}
			// if p1 + p2 > k then p2--
			if (currentSum > k) {
				return algorithm2(firstIndex, lastIndex - 1);
			}
			// if p1 + p2 < k then p1++
			else if (currentSum < k) {
				return algorithm2(firstIndex + 1, lastIndex);
			}

		}
		results.add(false);
		return results;
	}

	// swap values in array
	public void swapValues(int firstIndex, int secondIndex) {

		int swapValue = values[firstIndex];
		values[firstIndex] = values[secondIndex];
		values[secondIndex] = swapValue;

	}

	// get the location where the element should be moved to in the heap
	// by comparing child nodes
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

		// build the heap
		for (i = size / 2 - 1; i >= 0; i--)
			buildHeap(values[i], i, size - 1);

		// Sort the array.
		for (i = size - 1; i >= 1; i--) {
			swapValues(0, i);
			buildHeap(values[0], 0, i - 1);
		}
	}

}
