package by.epam.lab;

import by.epam.lab.beans.ExtraTrial;
import by.epam.lab.beans.LightTrial;
import by.epam.lab.beans.StrongTrial;
import by.epam.lab.beans.Trial;
import by.epam.lab.functionalInterface.Operationable;

import static by.epam.lab.utils.Constants.*;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        //1
        List<Trial> trials = new ArrayList<>(Arrays.asList(
                new Trial("Oleg", 40, 80),
                new Trial("Nat", 30, 40),
                new Trial("Inna", 60, 60),
                new LightTrial("Kate", 80, 70),
                new LightTrial("Dmitry", 50, 40),
                new StrongTrial("Ivan", 90, 60),
                new StrongTrial("Olesya", 90, 90),
                new ExtraTrial("Yan", 60, 70, 60),
                new ExtraTrial("Ilya", 70, 80, 40)));
        //2
        trials.forEach(System.out::println);
        //3
        System.out.println(RAW_DELIMITER);
        System.out.println(PASSED_TRIAL_COUNT + trials.stream()
                .filter(Trial::isPassed)
                .count());
        //4
        Operationable operation = trial -> trial.getMark1() + trial.getMark2();
        trials.sort(Comparator.comparingInt(operation::calculateMark));
        //5
        System.out.println(RAW_DELIMITER);
        trials.stream().
                map(operation::calculateMark)
                .forEach(System.out::println);
        //6
        System.out.println(RAW_DELIMITER);
        List<Trial> notPassedTrials = trials.stream()
                .filter(trial -> !trial.isPassed())
                .map(Trial::getCopy)
                .peek(Trial::clearMarks)
                .collect(Collectors.toList());

        notPassedTrials.forEach(System.out::println);

        System.out.println(notPassedTrials.stream()
                .allMatch(t -> !t.isPassed()));
        //7
        System.out.println(RAW_DELIMITER);
        int[] numericArray = trials.stream()
                .mapToInt(operation::calculateMark)
                .toArray();
        String str = Arrays.stream(numericArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(ARRAY_DELIMITER));
        System.out.println(str);
    }
}
