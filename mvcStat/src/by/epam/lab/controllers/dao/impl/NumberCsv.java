package by.epam.lab.controllers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import by.epam.lab.controllers.dao.NumberDAO;

public class NumberCsv implements NumberDAO {
	private final String[] param;

	public NumberCsv(String[] kind) {
		this.param = kind;
	}

	@Override
	public List<Double> getNumbers() {
		List<Double> numbers = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File(param[1]));
			while(sc.hasNext()) {
				String line = sc.next();
				String[] values = line.split(";");
				numbers.addAll(Stream.of(values)
						.mapToDouble(Double::parseDouble)
						.boxed()
						.toList());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return numbers;
	}
}
