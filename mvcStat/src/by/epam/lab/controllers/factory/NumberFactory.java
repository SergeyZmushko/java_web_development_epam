package by.epam.lab.controllers.factory;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.dao.impl.NumberCsv;
import by.epam.lab.controllers.dao.impl.NumberDb;
import by.epam.lab.controllers.dao.impl.NumberMemory;
import by.epam.lab.exceptions.InitException;
import by.epam.lab.utils.ConstantsJSP;
import jakarta.servlet.ServletConfig;

import static by.epam.lab.utils.ConstantsDAO.*;

import java.util.function.BiFunction;

public class NumberFactory {

	private enum Sources {
		MEMORY(NumberMemory::new),
		CSV(NumberCsv::new),
		DB(NumberDb::new);
		
		private final BiFunction<String, ServletConfig, NumberDAO> daoImpl;

		Sources(final BiFunction<String, ServletConfig, NumberDAO> daoImpl) {
			this.daoImpl = daoImpl;
		}

		private NumberDAO getImpl(String sourceParams, ServletConfig sc) {
			return daoImpl.apply(sourceParams, sc);
		}
	}

	private static NumberDAO numberImpl;

	public static void init(ServletConfig sc) throws InitException {
		String initParam = sc.getInitParameter(ConstantsJSP.FACTORY_NUMBER);
		String[] params = initParam.split(DELIMITER, SPLIT_LIMIT);
		String sourceType = params[FACTORY_NAME_IND];
		String sourceParams = params.length > 1 ? params[ACCESS_SOURCE_PARAMS_IND] : EMPTY_PARAMS;
		Sources source = Sources.valueOf(sourceType.toUpperCase());
		numberImpl = source.getImpl(sourceParams, sc);
	}

	public static NumberDAO getClassFromFactory() {
		return numberImpl;
	}

}
