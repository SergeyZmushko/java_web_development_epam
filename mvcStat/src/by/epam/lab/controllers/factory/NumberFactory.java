package by.epam.lab.controllers.factory;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.dao.impl.NumberCsv;
import by.epam.lab.controllers.dao.impl.NumberDb;
import by.epam.lab.controllers.dao.impl.NumberMemory;

public class NumberFactory {
	private static String kind;
	
	private enum NumberKind{
		MEMORY{
			protected NumberDAO getNumberKind() {
				return new NumberMemory();
			}
		},
		CSV{
			protected NumberDAO getNumberKind() {
				return new NumberCsv();
			}
		},
		DB{
			protected NumberDAO getNumberKind() {
				return new NumberDb();
			}
		};
		
		abstract protected NumberDAO getNumberKind();
	}
	
	private static NumberKind getNumberVar() {
		return NumberKind.valueOf(kind.toUpperCase());
	}
	
	public static void init (String initParam) {
		String[] param = initParam.split(";");
		kind = param[0];
	}
	
	public static NumberDAO getClassFromFactory() {
		return getNumberVar().getNumberKind();
	}

}
