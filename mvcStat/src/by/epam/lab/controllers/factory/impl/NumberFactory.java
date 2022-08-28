package by.epam.lab.controllers.factory.impl;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.dao.impl.NumberImplCsv;
import by.epam.lab.controllers.dao.impl.NumberImplDb;
import by.epam.lab.controllers.dao.impl.NumberImplMemory;
import by.epam.lab.controllers.factory.DaoImpl;
import by.epam.lab.exceptions.InitException;
import by.epam.lab.utils.ConstantsJSP;
import jakarta.servlet.ServletConfig;

import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberFactory {

	private enum Sources {
		MEMORY(NumberImplMemory::new),
		CSV(NumberImplCsv::new),
		DB(NumberImplDb::new);

		private final DaoImpl daoImpl;

		Sources(final DaoImpl daoImpl) {
			this.daoImpl = daoImpl;
		}

		private NumberDAO getImpl(String params, ServletConfig sc) {
			return daoImpl.getImpl(params, sc);
		}
	}

	private static NumberDAO numberImpl;

	public static void init(ServletConfig sc) throws InitException {
		String initParam = sc.getInitParameter(ConstantsJSP.FACTORY_NUMBER);
		String[] params = initParam.split(DELIMITER, 2);
		String sourceType = params[FACTORY_NAME];
		String sourceParams = params.length > 1 ? params[ACCESS_SOURCE_PARAMS_IND] : "";
		Sources source = Sources.valueOf(sourceType.toUpperCase());
		numberImpl = source.getImpl(sourceParams, sc);
	}

	public static NumberDAO getClassFromFactory() {
		return numberImpl;
	}

}
