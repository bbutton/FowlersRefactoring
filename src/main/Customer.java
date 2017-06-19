import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerName;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalRentalAmount = 0;
        int totalFrequentRenterPoints = 0;

        String statementText = "Rental record for " + getCustomerName() + "\n";
        for (Rental currentRental : rentals) {
            double currentRentalAmount = calculateCurrentRentalAmount(currentRental);
            totalFrequentRenterPoints += calculateCurrentFrequentRenterPoints(currentRental);

            // show figures for this rental
            statementText += "\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(currentRentalAmount) + "\n";

            totalRentalAmount += currentRentalAmount;
        }

        statementText += "Amount owed is " + String.valueOf(totalRentalAmount) + "\n";
        statementText += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";

        return statementText;
    }

    private int calculateCurrentFrequentRenterPoints(Rental currentRental) {
        int totalFrequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE && currentRental.getDaysRented() > 1)
            totalFrequentRenterPoints++;

        return totalFrequentRenterPoints;
    }

    private double calculateCurrentRentalAmount(Rental currentRental) {
        double currentRentalAmount = 0;
        switch (currentRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                currentRentalAmount += 2;
                if (currentRental.getDaysRented() > 2)
                    currentRentalAmount += (currentRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                currentRentalAmount += currentRental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                currentRentalAmount += 1.5;
                if (currentRental.getDaysRented() > 3)
                    currentRentalAmount += (currentRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return currentRentalAmount;
    }
}
