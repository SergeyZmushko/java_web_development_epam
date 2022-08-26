package by.epam.lab.controllers.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.lab.controllers.dao.NumberDAO;
import static by.epam.lab.utils.ConstantsJSP.*;

public class NumberDb implements NumberDAO {
	private final String[] strParam;

	public NumberDb(String[] param) {
		this.strParam = param;
	}

	@Override
	public List<Double> getNumbers() {
		List<Double> result = new ArrayList<>();
		try {
			Class.forName(CLASS_NAME);
			try (Connection cn = DriverManager.getConnection(DB_URL + strParam[DB_NAME_IND],
					strParam[USER_IND], strParam[PASSWORD_IND]); 
					Statement st = cn.createStatement()) {
				ResultSet rs = st.executeQuery(SQL_SELECT_NUMBERS);
				while (rs.next()) {
					double currentNumber = rs.getDouble(SQL_PARAM_VALUE);
					if (currentNumber >= MIN_NUMBER && currentNumber <= MAX_NUMBER) {
						result.add(currentNumber);
					}
				}
			} catch (SQLException e) {
				System.err.println(DATA_BASE_ERROR);
			}
		} catch (ClassNotFoundException e) {
			System.err.println(LOAD_CONNECTOR_ERROR);
		}
		return result;
	}

}
