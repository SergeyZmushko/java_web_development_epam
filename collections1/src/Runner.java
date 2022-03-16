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
        List<PricePurchase> purchases = new ArrayList<>();
        Map<Purchase, WeekDay> firstDayMap = new HashMap<>();
        Map<Purchase, WeekDay> lastDayMap = new HashMap<>();
        Map<WeekDay, List<Purchase>> enumDayMap = new HashMap<>();
        try(Scanner sc = new Scanner(new FileReader(FILE_NAME))){
            while (sc.hasNextLine()){
                Purchase purchase = PurchaseFactory.getPurchaseFromFactory(sc.nextLine());
                WeekDay day = WeekDay.valueOf(sc.nextLine());
                if (purchase instanceof PricePurchase){
                    purchases.add((PricePurchase) purchase);
                }
                if (!lastDayMap.containsKey(purchase)){
                    lastDayMap.put(purchase, day);
                    if (lastDayMap.containsKey(purchase) && !firstDayMap.containsKey(purchase)){
                        firstDayMap.put(purchase, day);
                    }
                }else{
                    firstDayMap.put(purchase, day);
                }
                if (!enumDayMap.containsKey(day)){
                    enumDayMap.put(day, new ArrayList<>());
                    enumDayMap.get(day).add(purchase);
                }else{
                    enumDayMap.get(day).add(purchase);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
        //2
        System.out.println(FIRST_DAY_MAP);
        printMap(lastDayMap);
        //4
        System.out.println(LAST_DAY_MAP);
        printMap(firstDayMap);
        //5
        System.out.println(FIND_BREAD_155);
        Purchase purchase = new Purchase("bread", new Byn(155), 6);
        findDayPurchase(firstDayMap, purchase);
        findDayPurchase(lastDayMap, purchase);
        //6
        System.out.println(FIND_BREAD_170);
        purchase = new Purchase("bread", new Byn(170), 6);
        findDayPurchase(firstDayMap, purchase);
        //7
        System.out.println(DELETE_MEAT_PURCHASE);
        deleteEntries(firstDayMap, "meat");
        printMap(firstDayMap);
        //8
        System.out.println(DELETE_FRIDAY_PURCHASE);
        deleteEntries(lastDayMap, FRIDAY);
        printMap(lastDayMap);
        //9
        System.out.println(FIRST_DAY_MAP);
        for (Map.Entry<Purchase, WeekDay> entry : firstDayMap.entrySet()){
            System.out.println(entry);
        }
        System.out.println(LAST_DAY_MAP);
        for (Map.Entry<Purchase, WeekDay> entry : lastDayMap.entrySet()){
            System.out.println(entry);
        }
        //11
        System.out.println(getCost(purchases));
        //13
        System.out.println(ENUM_DAY_MAP);
        printMap(enumDayMap);
        //14
        for (WeekDay entry : enumDayMap.keySet()){
            System.out.println(entry + ARROW + getCost(enumDayMap.get(entry)));
        }
        //15
        System.out.println(FIND_MONDAY_PURCHASE);
        findDayPurchase(enumDayMap, WeekDay.MONDAY);
    }

    private static <K, V> void printMap(Map<K , V> elements){
        for (Map.Entry<K, V> entry : elements.entrySet()){
            System.out.println(entry.getKey() + ARROW + entry.getValue());
        }
    }

    private static <T> void findDayPurchase(Map<? extends T, ? extends T> purchaseWeekDayHashMap, T purchase){
        for (Map.Entry<? extends T, ? extends T> entry : purchaseWeekDayHashMap.entrySet()){
            if (entry.getKey().equals(purchase) || entry.getValue().equals(purchase)){
                System.out.println(entry.getKey() + ARROW + entry.getValue());
            }
        }
    }

    private static void deleteEntries(Map<Purchase, WeekDay> purchaseWeekDayHashMap, String name){
        Set<Purchase> keysToRemove = new HashSet<>();
        for (Map.Entry<Purchase, WeekDay> entry : purchaseWeekDayHashMap.entrySet()){
            Purchase purchase = entry.getKey();
            WeekDay weekDay = entry.getValue();
            if (purchase.toString().contains(name) || weekDay.getDay().toUpperCase(Locale.ROOT).contains(name)){
                keysToRemove.add(purchase);
            }
        }
        purchaseWeekDayHashMap.keySet().removeAll(keysToRemove);
    }

    private static <T extends Purchase> Byn getCost(List<T> purchaseList){
        Byn result = new Byn();
        for (Purchase purchases : purchaseList){
            result.add(purchases.getCost());
        }
        return result;
    }
}
