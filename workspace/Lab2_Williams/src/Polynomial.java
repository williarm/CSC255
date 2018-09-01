
import java.util.Vector;

/**
 * Purpose: The Polynomial class is designed to calculate the value of a
 * Polynomial using three different algorithms.
 * 
 * Constructors: Polynomial
 * 
 * Methods: algorithmOne, algorithmTwo, hornersRule
 * 
 * @author Robert Williams
 * @since 2018-09-01
 * 
 */

public class Polynomial {
	//

	static int degree;
	static double x;
	static Vector terms;

	public Polynomial(double x, int degree, Vector terms) {
		this.x = x;
		this.degree = degree;
		this.terms = terms;
	}

	public Vector algorithmOne() {
		// Calculate 𝑝(𝑥)=𝑎𝑁𝑥𝑁+𝑎𝑁−1𝑥𝑁−1+⋯+𝑎3𝑥3+𝑎2𝑥2+𝑎1𝑥+𝑎0
		double result = 0;
		int operations = 0;
		Vector returnValues = new Vector();

		long t1 = 0;
		long t2 = 0;

		for (int i = degree; i >= 1; --i) {

			int exponent = 0;

			if (i - 1 < 1) {
				exponent = 1;
			} else
				exponent = i;
			t1 = System.nanoTime();
			result += (double) terms.get(i) * (int) Math.pow(x, exponent);
			t2 = System.nanoTime();
			operations++;

		}
		result += (double) terms.get(0);

		returnValues.add(result);
		returnValues.add(operations);
		returnValues.add(String.format("%3.3e", (double) (t2 - t1)));

		return returnValues;
	}

	public Vector algorithmTwo() {
		// Calculate 𝑝(𝑥)=𝑥,𝑥2..𝑥𝑁−1,𝑥𝑁

		long t1 = 0;
		long t2 = 0;
		int operations = 0;
		Vector coeffecients = new Vector();
		Vector returnValues = new Vector();

		for (int i = 0; i <= degree; i++) {
			int exponent = 0;
			if (i == 0) {
				exponent = 1;
			} else
				exponent = i;

			coeffecients.add(Math.pow(x, exponent));
		}

		double result = (double) terms.get(0);
		for (int i = 1; i < terms.size(); i++) {
			t1 = System.nanoTime();
			result += ((double) terms.get(i) * (double) coeffecients.get(i));
			t2 = System.nanoTime();
			operations++;
		}

		returnValues.add(result);
		returnValues.add(operations);
		returnValues.add(String.format("%3.3e", (double) (t2 - t1)));

		return returnValues;
	}

	public Vector hornersRule() {
		double result = 0;
		long t1 = 0;
		long t2 = 0;
		int operations = 0;
		Vector returnValues = new Vector();
		for (int i = degree; i >= 0; --i) {
			t1 = System.nanoTime();
			result = x * result + (double) terms.get(i);
			t2 = System.nanoTime();
			operations++;
		}
		returnValues.add(result);
		returnValues.add(operations);
		returnValues.add(String.format("%3.3e", (double) (t2 - t1)));
		return returnValues;
	}

}
