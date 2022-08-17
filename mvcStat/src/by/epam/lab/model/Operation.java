package by.epam.lab.model;

import static by.epam.lab.utils.ConstantsOperation.*;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.DoubleBinaryOperator;

public enum Operation {
	SUM(SYMBOL_SUM, Double::sum), 
	MAX(SYMBOL_MAX, Double::max), 
	MIN(SYMBOL_MIN, Double::min),
	AVG(SYMBOL_AVG, Double::sum);

	private final String value;
	private final DoubleBinaryOperator doubleBinaryOperator;

	Operation(String value, final DoubleBinaryOperator doubleBinaryOperator) {
		this.value = value;
		this.doubleBinaryOperator = doubleBinaryOperator;
	}

	public double result(double... n) {
		double result = 0;
		OptionalDouble sum = Arrays.stream(n)
				.reduce(doubleBinaryOperator::applyAsDouble);
		if (sum.isPresent()) {
			result = sum.getAsDouble();
		}
		if (SYMBOL_AVG == value) {
			result /= n.length;
		}
		return result;
	}
}
