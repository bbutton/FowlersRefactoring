public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MovieType movieType;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setPriceCode(int priceCode) {
        switch(priceCode) {
            case Movie.REGULAR:
                movieType = new RegularMovieType();
                break;

            case Movie.NEW_RELEASE:
                movieType = new NewReleaseMovieType();
                break;

            case Movie.CHILDREN:
                movieType = new ChildrensMovieType();
                break;
        }
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        return movieType.calculateFrequentRenterPoints(daysRented);
    }

    public double calculateRentalAmount(int daysRented) {
        return movieType.calculateRentalAmount(daysRented);
    }
}
