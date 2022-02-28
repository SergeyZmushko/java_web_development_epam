package by.epam.lab.services;

import by.epam.lab.beans.PriceDiscountPurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.exceptions.CsvLineException;
import by.epam.lab.exceptions.NegativeArgumentException;
import by.epam.lab.exceptions.NonPositiveArgumentException;

public class PurchaseFactory {
    private static final String SEMICOLON = ";";

    private enum PurchaseKind {
        GENERAL_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new Purchase(fields);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new PriceDiscountPurchase(fields);
            }
        };

        abstract protected Purchase getPurchase(String[] fields);
    }

    private static PurchaseKind getPurchaseKind(int length) {
        int indexDifference = 3;
        return PurchaseKind.values()[length - indexDifference];
    }

    public static Purchase getPurchaseFromFactory(String csvLine) throws CsvLineException {
        String[] fields = csvLine.split(SEMICOLON);
        try {
            return getPurchaseKind(fields.length).getPurchase(fields);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            throw new CsvLineException(csvLine, e);
        }
    }
}
