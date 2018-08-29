
import java.util.Vector;

public class Polynomial {

	static int degree;
	static double x;
	static Vector terms;

	public Polynomial(double x, int degree, Vector terms) {
		this.x = x;
		this.degree = degree;
		this.terms = terms;
	}

	public double algorithmOne() {
		// Calculate 𝑝(𝑥)=𝑎𝑁𝑥𝑁+𝑎𝑁−1𝑥𝑁−1+⋯+𝑎3𝑥3+𝑎2𝑥2+𝑎1𝑥+𝑎0
		double result = 0;
		for (int i = degree; i >= 1; --i) {

			int exponent = 0;

			if (i - 1 < 1) {
				exponent = 1;
			} else
				exponent = i;

			result += (double) terms.get(i) * (int) Math.pow(x, exponent);
		}
		result += (double) terms.get(0);
		return result;
	}

	public double algorithmTwo() {
		// Calculate 𝑝(𝑥)=𝑥,𝑥2..𝑥𝑁−1,𝑥𝑁
		Vector coeffecients = new Vector();

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
			result += ((double) terms.get(i) * (double) coeffecients.get(i));
		}
		return result;
	}

	public double hornersRule() {
		double result = 0;
		for (int i = degree; i >= 0; --i) {
			result = x * result + (double) terms.get(i);
		}
		return result;
	}

}
