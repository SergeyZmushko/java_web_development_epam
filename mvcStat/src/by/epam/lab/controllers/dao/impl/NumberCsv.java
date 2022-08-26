package by.epam.lab.controllers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import by.epam.lab.controllers.dao.NumberDAO;
import static by.epam.lab.utils.ConstantsJSP.*;

public class NumberCsv implements NumberDAO {
	private final String[] param;

	public NumberCsv(String[] param) {
		this.param = param;
	}

	@Override
	public List<Double> getNumbers() {
		List<Double> numbers = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File(param[FILE_NAME_IND]));
			while (sc.hasNext()) {
				String line = sc.next();
				String[] values = line.split(DELIMITER);
				numbers.addAll(Stream.of(values)
						.mapToDouble(Double::parseDouble)
						.filter(i -> i <= MAX_NUMBER && i >= MIN_NUMBER)
						.boxed()
						.toList());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(FILE_NOT_FOUND);
		}
		return numbers;
	}
}
