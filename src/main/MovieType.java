/**
 * Created by bbutton on 6/18/17.
 */
public abstract class MovieType {
    public abstract int getMovieType();

    public double calculateRentalAmount(int daysRented) {
        double rentalAmount = 0;
        switch (getMovieType()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
}
