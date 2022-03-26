import by.epam.lab.beans.Byn;
import by.epam.lab.beans.PricePurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.enums.PurchaseFactory;
import by.epam.lab.enums.WeekDay;

import static by.epam.lab.utils.Constant.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        final String FILE_NAME = "src/in.csv";
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            List<PricePurchase> priceDiscountPurchases = new ArrayList<>();
            Map<Purchase, WeekDay> firstPurchasesMap = new HashMap<>();
            Map<Purchase, WeekDay> lastPurchasesMap = new HashMap<>();
            Map<WeekDay, List<Purchase>> dayPurchasesMap = new EnumMap<>(WeekDay.class);
            while (sc.hasNextLine()) {
                Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc.nextLine());
                WeekDay day = WeekDay.valueOf(sc.nextLine());
                lastPurchasesMap.put(purchase, day);
                if (!firstPurchasesMap.containsKey(purchase)) {
                    firstPurchasesMap.put(purchase, day == firstPurchasesMap.get(purchase) ? firstPurchasesMap.get(purchase) : day);
                }
                List<Purchase> purchases = dayPurchasesMap.get(day);
                if (purchases == null) {
                    dayPurchasesMap.put(day, purchases = new ArrayList<>());
                }
                purchases.add(purchase);
                if (purchase instanceof PricePurchase) {
                    priceDiscountPurchases.add((PricePurchase) purchase);
                }
            }
            //2
            printMap(lastPurchasesMap, LAST_DAY_MAP);
            //4
            printMap(firstPurchasesMap, FIRST_DAY_MAP);
            //5
            Purchase purchase1 = new Purchase("bread", new Byn(155), 6);
            findAndShow(firstPurchasesMap, purchase1, FIND_BREAD_155_FIRST);
            findAndShow(lastPurchasesMap, purchase1, FIND_BREAD_155_LAST);
            //6
            Purchase purchase2 = new Purchase("bread", new Byn(170), 6);
            findAndShow(firstPurchasesMap, purchase2, FIND_BREAD_170);
            //7
            removeEntries(lastPurchasesMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getKey().getName().equals("meat");
                }
            });
            //8
            removeEntries(firstPurchasesMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Map.Entry<Purchase, WeekDay> entry) {
                    return entry.getValue().equals(WeekDay.FRIDAY);
                }
            });
            //9
            System.out.println(FIRST_DAY_MAP_AFTER_REMOVE);
            for (Map.Entry<Purchase, WeekDay> entry : firstPurchasesMap.entrySet()) {
                System.out.println(entry);
            }
            System.out.println(LAST_DAY_MAP_AFTER_REMOVE);
            for (Map.Entry<Purchase, WeekDay> entry : lastPurchasesMap.entrySet()) {
                System.out.println(entry);
            }
            //11
            System.out.println(getCost(priceDiscountPurchases));
            //13
            printMap(dayPurchasesMap, ENUM_DAY_MAP);
            //14
            for (Map.Entry<WeekDay, List<Purchase>> entry : dayPurchasesMap.entrySet()) {
                System.out.println(entry.getKey() + ARROW + getCost(entry.getValue()));
            }
            //15
            findAndShow(dayPurchasesMap, WeekDay.MONDAY, FIND_MONDAY_PURCHASE);
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }

    private static <K, V> void printMap(Map<K, V> map, String message) {
        System.out.println(message);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ARROW + entry.getValue());
        }
    }

    private static <K, V> void findAndShow(Map<K, V> map, K searchKey, String header) {
        System.out.println(header);
        if (map.get(searchKey) != null) {
            System.out.println(map.get(searchKey));
        } else {
            System.out.println(PURCHASE_IS_NOT_FOUND);
        }
    }

    public interface EntryChecker<K, V> {
        boolean check(Map.Entry<K, V> entry);
    }

    private static <K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> checker) {
        for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
            if (checker.check((Map.Entry) it.next())) {
                it.remove();
            }
        }
    }

    private static Byn getCost(List<? extends Purchase> purchaseList) {
        Byn result = new Byn();
        for (Purchase purchases : purchaseList) {
            result.add(purchases.getCost());
        }
        return result;
    }
}
