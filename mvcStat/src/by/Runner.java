package by;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	 public static void main (String[] args) {
		List<Double> numbers = new ArrayList<>();
		try {
			File file = new File("E:/java_web_development_epam/mvcStat/webapp/WEB-INF/resources/numbers.csv");
			System.out.println(file.isFile());
			Scanner sc = new Scanner(file);
			sc.useDelimiter(";");
			while(sc.hasNext()) {
				String str = sc.next();
				System.out.println(str);
				double res = Double.parseDouble(str);
				numbers.add(res);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(numbers);

	}

}
