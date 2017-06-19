/**
 * Created by bbutton on 6/18/17.
 */
public class RegularMovieType extends MovieType {
    @Override
    public int getMovieType() {
        return Movie.REGULAR;
    }

    @Override
    public double calculateRentalAmount(int daysRented) {
        double rentalAmount = 2;

        if (daysRented > 2)
            rentalAmount += (daysRented - 2) * 1.5;

        return rentalAmount;
    }

}
