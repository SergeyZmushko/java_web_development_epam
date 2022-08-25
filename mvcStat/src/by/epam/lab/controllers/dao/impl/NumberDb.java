package by.epam.lab.controllers.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import by.epam.lab.controllers.dao.NumberDAO;
import jakarta.servlet.ServletConfig;

public class NumberDb implements NumberDAO {
	private final String[] kind;

	public NumberDb(String[] kind) {
		this.kind = kind;
	}

	@Override
	public List<Double> getNumbers() {
		try (Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	         Statement st = cn.createStatement();
				PreparedStatement ps = cn.prepareStatement(null);
		return null;
	}

}
