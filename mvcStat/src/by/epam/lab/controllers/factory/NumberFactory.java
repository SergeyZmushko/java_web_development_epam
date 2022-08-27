package by.epam.lab.controllers.factory;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.dao.impl.NumberCsv;
import by.epam.lab.controllers.dao.impl.NumberDb;
import by.epam.lab.controllers.dao.impl.NumberMemory;
import static by.epam.lab.utils.ConstantsDAO.*;

public class NumberFactory {
	private static String[] params;

	private enum NumberKind {
		MEMORY {
			protected NumberDAO getNumberKind() {
				return new NumberMemory();
			}
		},
		CSV {
			protected NumberDAO getNumberKind() {
				return new NumberCsv(params[FILE_NAME_IND]);
			}
		},
		DB {
			protected NumberDAO getNumberKind() {
				return new NumberDb(params[DB_NAME_IND], params[USER_IND], params[PASSWORD_IND]);
			}
		};

		abstract protected NumberDAO getNumberKind();
	}

	private static NumberKind getNumberVar() {
		return NumberKind.valueOf(params[FACTORY_NAME].toUpperCase());
	}

	public static void init(String initParam) {
		params = initParam.split(DELIMITER);
	}

	public static NumberDAO getClassFromFactory() {
		return getNumberVar().getNumberKind();
	}

}
