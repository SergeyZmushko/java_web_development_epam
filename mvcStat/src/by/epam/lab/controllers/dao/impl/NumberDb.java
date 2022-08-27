package by.epam.lab.controllers.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.exceptions.InitException;

import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberDb implements NumberDAO {
	private final String url;
	private final String user;
	private final String password;

	public NumberDb(String dbName, String user, String password) {
		this.url = DB_URL + dbName;
		this.user = user;
		this.password = password;
	}

	@Override
	public List<Double> getNumbers() throws InitException {
		try {
			Class.forName(CLASS_NAME);
			try (Connection cn = DriverManager.getConnection(url, user, password);
					Statement st = cn.createStatement();
					ResultSet rs = st.executeQuery(SQL_SELECT_NUMBERS)) {
				List<Double> result = new ArrayList<>();
				while (rs.next()) {
					result.add(rs.getDouble(SQL_PARAM_VALUE));
				}
				return result;
			} catch (SQLException e) {
				throw new InitException(DATA_BASE_ERROR);
			}
		} catch (ClassNotFoundException e) {
			throw new InitException(LOAD_CONNECTOR_ERROR);
		}
	}
}
