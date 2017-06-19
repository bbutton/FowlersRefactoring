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
        String statementText = "Rental record for " + getCustomerName() + "\n";

        for (Rental currentRental : rentals) {
            statementText += "\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(currentRental.calculateRentalAmount()) + "\n";
        }

        statementText += "Amount owed is " + String.valueOf(calculateTotalRentalAmount()) + "\n";
        statementText += "You earned " + String.valueOf(calculateTotalFrequentRenterPoints()) + " frequent renter points";

        return statementText;
    }

    private double calculateTotalRentalAmount() {
        double totalRentalAmount = 0.0;

        for (Rental currentRental : rentals) {
            totalRentalAmount += currentRental.calculateRentalAmount();
        }
        return totalRentalAmount;
    }

    private int calculateTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;

        for (Rental currentRental : rentals) {
            totalFrequentRenterPoints += currentRental.calculateFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

}
