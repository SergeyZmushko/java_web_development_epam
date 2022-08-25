package by.epam.lab.controllers.factory;

import by.epam.lab.controllers.dao.NumberDAO;
import by.epam.lab.controllers.dao.impl.NumberCsv;
import by.epam.lab.controllers.dao.impl.NumberDb;
import by.epam.lab.controllers.dao.impl.NumberMemory;

public class NumberFactory {
	private static String[] kind;
	
	private enum NumberKind{
		MEMORY{
			protected NumberDAO getNumberKind() {
				return new NumberMemory();
			}
		},
		CSV{
			protected NumberDAO getNumberKind() {
				return new NumberCsv(kind);
			}
		},
		DB{
			protected NumberDAO getNumberKind() {
				return new NumberDb(kind);
			}
		};
		
		abstract protected NumberDAO getNumberKind();
	}
	
	private static NumberKind getNumberVar() {
		return NumberKind.valueOf(kind[0].toUpperCase());
	}
	
	public static void init (String initParam) {
		String[] param = initParam.split(";");
		kind = param;
	}
	
	public static NumberDAO getClassFromFactory() {
		return getNumberVar().getNumberKind();
	}

}
