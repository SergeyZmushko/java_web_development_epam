package by.epam.lab.controllers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.lab.controllers.dao.NumberDAO;

public class NumberCsv implements NumberDAO {

	@Override
	public List<Double> getNumbers() {
		List<Double> numbers = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("E:\\java_web_development_epam\\mvcStat\\webapp\\WEB-INF\\resources\numbers.csv"));
			sc.useDelimiter(";");
			while(sc.hasNext()) {
				numbers.add(sc.nextDouble());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return numbers;
	}
	

}
