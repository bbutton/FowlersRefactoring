/**
 * Created by bbutton on 6/18/17.
 */
public class ChildrensMovieType extends MovieType {
    @Override
    public int getMovieType() {
        return Movie.CHILDREN;
    }

    @Override
    public double calculateRentalAmount(int daysRented) {
        double rentalAmount = 1.5;

        if (daysRented > 3)
            rentalAmount += (daysRented - 3) * 1.5;

        return rentalAmount;
    }
}
