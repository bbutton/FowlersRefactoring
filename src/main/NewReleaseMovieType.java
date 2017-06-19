/**
 * Created by bbutton on 6/18/17.
 */
public class NewReleaseMovieType extends MovieType {
    @Override
    public int getMovieType() {
        return Movie.NEW_RELEASE;
    }

    public double calculateRentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = super.calculateFrequentRenterPoints(daysRented);

        // add bonus for a two day new release rental
        if (daysRented > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
