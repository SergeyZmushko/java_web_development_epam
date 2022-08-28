package by.epam.lab.controllers.factory;

import by.epam.lab.controllers.dao.NumberDAO;
import jakarta.servlet.ServletConfig;

public interface DaoImpl {
	NumberDAO getImpl(String params, ServletConfig sc);
}
