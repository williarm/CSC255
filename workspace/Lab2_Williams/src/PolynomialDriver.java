import java.io.FileNotFoundException;
import java.util.Vector;

public class PolynomialDriver {

	public static void main(String[] args) throws FileNotFoundException {

		FileReader.readFile("r5.txt");

		Vector v = new Vector();

		for (int i = 1; i <= FileReader.data.size() - 1; i++) {
			v.add(FileReader.data.get(i));
		}

		Polynomial p = new Polynomial(FileReader.data.get(0), FileReader.data.size() - 2, v);

		System.out.println("Algorithm One: " + p.algorithmOne());

		System.out.println("Algorithm Two: " + p.algorithmTwo());

		System.out.println("Horners Rule: " + p.hornersRule());

	}

}
