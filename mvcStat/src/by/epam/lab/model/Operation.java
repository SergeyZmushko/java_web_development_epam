package by.epam.lab.model;

import static by.epam.lab.utils.ConstantsOperation.*;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum Operation {
	SUM(SYMBOL_SUM, Double::sum),
	MAX(SYMBOL_MAX, Double::max),
	MIN(SYMBOL_MIN, Double::min),
	AVG(SYMBOL_AVG, Double::sum);

	private final DoubleBinaryOperator doubleBinaryOperator;

	Operation(String value, final DoubleBinaryOperator doubleBinaryOperator) {
		this.doubleBinaryOperator = doubleBinaryOperator;
	}

	public double result(double... n) {
		double result = Arrays.stream(n).reduce(doubleBinaryOperator).getAsDouble();
		if (this == AVG) {
			result /= n.length;
		}
		return result;
	}
}
