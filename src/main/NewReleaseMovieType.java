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
}
