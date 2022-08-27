package by.epam.lab.controllers.dao;

import java.util.List;

import by.epam.lab.exceptions.InitException;

public interface NumberDAO {
	List<Double> getNumbers() throws InitException;

}
