package by.epam.lab.impl;

import java.util.Map;

public interface EntryChecker<K, V> {
    boolean check(Map.Entry<K, V> entry);
}
