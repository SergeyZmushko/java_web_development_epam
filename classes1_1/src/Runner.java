import by.epam.lab.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        // 1.
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Uladzimir Kovalchuk", 135, 5),
                new BusinessTrip("Viacheslav Zaicev", 540, 9),
                null,
                new BusinessTrip("Sergey Podolski", 5, 2),
                new BusinessTrip()
        };

        // 2.
        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null) {
                businessTrip.show();
                System.out.println();
            } else {
                System.out.println("empty element \n");
            }
        }

        System.out.println("Business trip with maximum cost:");
        int currentTotal = 0;

        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null && businessTrip.getTotal() >= currentTotal) {
                currentTotal = businessTrip.getTotal();
            }
        }

        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null && businessTrip.getTotal() == currentTotal) {
                System.out.println(businessTrip);
            }
        }

        // 3.
        businessTrips[businessTrips.length - 1].setExpenses(10000);

        // 4.
        System.out.println("Total duration of two initial business trips:");
        int duration = businessTrips[0].getDaysNumber() + businessTrips[1].getDaysNumber();
        System.out.println("DURATION = " + duration);

        // 5.
        System.out.println("Array content to the console");
        for (BusinessTrip businessTrip : businessTrips) {
            System.out.println(businessTrip);
        }
    }
}
