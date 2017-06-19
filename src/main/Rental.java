import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

    public double calculateRentalAmount() {
        double rentalAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (getDaysRented() > 2)
                    rentalAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                rentalAmount += 1.5;
                if (getDaysRented() > 3)
                    rentalAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
}
