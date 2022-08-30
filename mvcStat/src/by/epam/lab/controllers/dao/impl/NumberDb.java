package by.epam.lab.controllers.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.exceptions.InitException;
import by.epam.lab.exceptions.InitRuntimeException;
import jakarta.servlet.ServletConfig;

import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberDb implements NumberDAO {
	private final String url;
	private final String user;
	private final String password;
	static {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException e) {
			throw new InitRuntimeException(e);
		}
	}

	public NumberDb(String params, ServletConfig sc) {
		String[] param = params.split(DELIMITER);
		this.url = DB_URL + param[DB_NAME_IND];
		this.user = param[USER_IND];
		this.password = param[PASSWORD_IND];
	}

	@Override
	public List<Double> getNumbers() throws InitException {
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
	}
}
