public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private MovieType movieType;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return movieType.getMovieType();
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
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

    public double calculateRentalAmount(int daysRented) {
        double rentalAmount = 0;
        switch (getPriceCode()) {
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
