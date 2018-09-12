
public class SumOfNumbers {

	// O(N^2) operation
	static boolean algorithm1(int[] values, int k) {

		boolean sumExists = false;

		for (int i = 0; i < values.length; i++) {

			int maxIndex = values.length - 1;
			//System.out.println(maxIndex);
			System.out.println("Loop: " + i);

			/*
			 * condition to check if the loop is at the last value. if so, add the value to
			 * itself and determine match
			 */

			if (i == values.length - 1) {
				if (values[i] * 2 == k) {
					System.out.println("Step 1: Yes " + values[i] * 2);
					sumExists = true;
					break;
				}

			}

			/*
			 * condition for checking the value of the current index plus itself
			 */

			else if (values[i] * 2 == k) {
				System.out.println("Step 2: Yes " + values[i] * 2);
				sumExists = true;
				break;
			}

			/*
			 * condition for checking the value of current index plus the remaining values
			 * in the array
			 */

			else {
				for (int j = i; j < values.length; j++) {
					System.out.println("In third loop");
					if (values[i] + values[j] == k) {
						System.out.println("Step 3: Yes " + (values[i] + values[j]));
						sumExists = true;
						break;
					}

				}

			}

			if (sumExists) {
				break;
			}

		}

		return sumExists;
	}

	// Heap Sort is an O(N log(N)) algorithm
	static boolean heapSort() {
		return true;
	}

	public static void main(String[] args) {

		int k = 15;
		int[] values = new int[12];

		values[0] = 5;
		values[1] = 1;
		values[2] = 10;
		values[3] = 9;
		values[4] = 7;
		values[5] = 4;
		values[6] = 3;
		values[7] = 5;
		values[8] = 5;
		values[9] = 3;
		values[10] = 2;
		values[11] = 95;

		algorithm1(values, k);

	}

}
