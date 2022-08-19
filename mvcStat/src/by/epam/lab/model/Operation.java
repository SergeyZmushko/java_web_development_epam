package by.epam.lab.model;


import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.function.Function;

public enum Operation {
	SUM(DoubleSummaryStatistics::getSum),
	MAX(DoubleSummaryStatistics::getMax),
	MIN(DoubleSummaryStatistics::getMin),
	AVG(DoubleSummaryStatistics::getAverage);

	private final Function<DoubleSummaryStatistics, Double> terminalOperation;

	Operation(final Function<DoubleSummaryStatistics, Double> terminalOperation) {
		this.terminalOperation = terminalOperation;
	}

	public double result(double[] numbers) {
		return terminalOperation.apply(Arrays.stream(numbers).summaryStatistics());
	}
}
