package by.epam.lab.controllers.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.exceptions.InitException;

import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberCsv implements NumberDAO {
	private final String path;

	public NumberCsv(String path) {
		this.path = path;
	}

	@Override
	public List<Double> getNumbers() throws InitException {
		try (Scanner sc = new Scanner(new File(path))) {
			List<Double> numbers = new ArrayList<>();
			while (sc.hasNext()) {
				String line = sc.next();
				String[] values = line.split(DELIMITER);
				numbers.addAll(Arrays.stream(values)
						.mapToDouble(Double::parseDouble)
						.boxed()
						.toList());
			}
			return numbers;
		} catch (FileNotFoundException | NumberFormatException e) {
			throw new InitException(LOAD_NUMBERS_ERROR);
		}
	}
}
