package by.epam.lab;

import by.epam.lab.beans.ExtraTrial;
import by.epam.lab.beans.LightTrial;
import by.epam.lab.beans.StrongTrial;
import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.*;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = new ArrayList<>();
        trials.add(new Trial("Oleg", 40, 80));
        trials.add(new Trial("Nat", 30, 40));
        trials.add(new Trial("Inna", 60, 60));
        trials.add(new LightTrial("Kate", 80, 70));
        trials.add(new LightTrial("Dmitry", 50, 40));
        trials.add(new StrongTrial("Ivan", 90, 60));
        trials.add(new StrongTrial("Olesya", 90, 90));
        trials.add(new ExtraTrial("Yan", 60, 70, 60));
        trials.add(new ExtraTrial("Ilya", 70, 80, 40));

        trials.forEach(System.out::println);

        System.out.println(RAW_DELIMITER);
        long count = trials.stream()
                .filter(Trial::isPassed)
                .count();
        System.out.println(PASSED_TRIAL_COUNT + count);

        trials.sort(Comparator.comparing(Runner::markSum));

        System.out.println(RAW_DELIMITER);
        trials.stream().
                mapToInt(Runner::markSum)
                .forEach(System.out::println);

        System.out.println(RAW_DELIMITER);
        List<Trial> notPassedTrials = trials.stream()
                .filter(trial -> !trial.isPassed())
                .peek(trial -> {
                    trial.setMark1(0);
                    trial.setMark2(0);
                })
                .collect(Collectors.toList());

        boolean match = notPassedTrials.stream()
                .allMatch(t -> !t.isPassed());
        notPassedTrials.forEach(System.out::println);
        System.out.println(match);

        System.out.println(RAW_DELIMITER);
        int[] numericArray = trials.stream()
                .mapToInt(Runner::markSum)
                .toArray();
        String str = Arrays.stream(numericArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(ARRAY_DELIMITER));
        System.out.println(str);
    }

    private static int markSum(Trial trial) {
        return trial.getMark1() + trial.getMark2();
    }
}
