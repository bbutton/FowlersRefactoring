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
        return generateHeader() + generateBody() + generateFooter();
    }

    private String generateFooter() {
        return "Amount owed is " + String.valueOf(calculateTotalRentalAmount()) + "\n"
                + "You earned " + String.valueOf(calculateTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private String generateBody() {
        String statementText = "";
        for (Rental currentRental : rentals) {
            statementText += "\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(currentRental.calculateRentalAmount()) + "\n";
        }
        return statementText;
    }

    private String generateHeader() {
        return "Rental record for " + getCustomerName() + "\n";
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
