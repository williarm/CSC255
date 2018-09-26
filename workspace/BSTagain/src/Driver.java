import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Vector;

public class Driver {

	public static void compareData(String output, Set<String> people, Vector<String> dataOriginal, int size) {
		if (size == -1) {
			size = dataOriginal.size();
		}

		Vector<String> dataTemp = (Vector<String>) dataOriginal.clone();
		Collections.sort(dataTemp);

		for (int i = 0; i < dataOriginal.size(); i++) {
			people.insert(dataOriginal.get(i));
		}

		SetIterator<String> person = people.begin();
		
		for (int i = 0; person.hasNext() && i < size; i++) {
			if(dataTemp.isEmpty()) {
				
			}
			if (!(person.getElement().equals(dataTemp.get(i)))) {
				System.out.println("Equals");
			}
			person.advance();
		}

		while (person.hasNext()) {
			System.out.println(person.getElement());
			person.advance();
		}

		person = people.end();

	}

	public void printPeople(String output, Set<String> people, String description, boolean end) {

	}

	public void findPerson(String output, Set<String> people, String name) {

	}

	public static void main(String[] args) throws FileNotFoundException {

		try {
			Vector<String> data = new Vector<String>();
			Set<String> people = new Set<String>();
			String output = new String();

			// read input file into data;
			FileReader file = new FileReader("in.txt");

			file.readFile();

			for (int i = 0; i < file.data.size(); i++) {
				data.add(file.data.get(i));
			}

			compareData(output, people, data, data.size());

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

	}
}
