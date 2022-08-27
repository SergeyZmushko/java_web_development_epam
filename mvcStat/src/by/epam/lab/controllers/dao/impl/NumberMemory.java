package by.epam.lab.controllers.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam.lab.controllers.dao.NumberDAO;

public class NumberMemory implements NumberDAO {
	private List<Double> numbers = new ArrayList<>(
			Arrays.asList(2.2, 3.2, 2.5, 5.0, 2.3, 10.0, 11.2, 
					-12.3, 45.6, 78.5, 99.6, 100.1, 2.6, -1001.3, 1002.0));

	@Override
	public List<Double> getNumbers() {
		return numbers.stream()
				.toList();
	}

}
