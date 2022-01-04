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
        BusinessTrip businessTripMax = new BusinessTrip();
        for (BusinessTrip businessTrip : businessTrips) {
            if(businessTrip == null){
                continue;
            }
            businessTrip.show();
            if (businessTrip.getTotal() > businessTripMax.getTotal()){
                businessTripMax = businessTrip;
            }
        }
        System.out.println("Max total trip: " + businessTripMax);

        // 3.
        businessTrips[businessTrips.length - 1].setExpenses(10000);

        // 4.
        System.out.println("Total duration of two initial business trips:");
        System.out.println("DURATION = " + (businessTrips[0].getDaysNumber() +
                businessTrips[1].getDaysNumber()));

        // 5.
        System.out.println("Array content to the console");
        for (BusinessTrip businessTrip : businessTrips) {
            System.out.println(businessTrip);
        }
    }
}
