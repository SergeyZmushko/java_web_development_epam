package by.epam.lab.controllers.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.exceptions.InitException;
import jakarta.servlet.ServletConfig;

import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberCsv implements NumberDAO {
	private final String csvName;

	public NumberCsv(String csvName, ServletConfig sc) {
		this.csvName = sc.getServletContext().getRealPath(REAL_PATH) + csvName;
	}

	@Override
	public List<Double> getNumbers() throws InitException {
		try (Scanner sc = new Scanner(new FileReader(csvName))) {
			String csvLine = sc.next();
			return Arrays.stream(csvLine.split(DELIMITER))
					.map(Double::parseDouble)
					.toList();
		} catch (FileNotFoundException | NumberFormatException e) {
			throw new InitException(LOAD_NUMBERS_ERROR + csvName);
		}
	}
}
