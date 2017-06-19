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
            statementText += "\t" + currentRental.getMovie().getTitle() + "\t" + String.valueOf(calculateCurrentRentalAmount(currentRental)) + "\n";
        }

        statementText += "Amount owed is " + String.valueOf(calculateTotalRentalAmount()) + "\n";
        statementText += "You earned " + String.valueOf(calculateTotalFrequentRenterPoints()) + " frequent renter points";

        return statementText;
    }

    private double calculateTotalRentalAmount() {
        double totalRentalAmount = 0.0;

        for (Rental currentRental : rentals) {
            totalRentalAmount += calculateCurrentRentalAmount(currentRental);
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
