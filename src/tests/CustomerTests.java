import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    @Test
    public void costsGeneratedCorrectlyForNewReleaseMovie() {
        Customer customer = new Customer("Nelly NewRelease");
        Movie newReleaseMovie = new Movie("New Release Movie", Movie.NEW_RELEASE);
        customer.addRental(new Rental(newReleaseMovie, 3));

        String statement = customer.statement();

        assertEquals("Rental record for Nelly NewRelease\n" +
                "\tNew Release Movie\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void costGeneratedCorrectlyForOfChildrensMovie() {
        Customer customer = new Customer("Charlie Child");
        Movie childrensMovie = new Movie("SpongeBob and the Sentence Enhancers", Movie.CHILDREN);
        customer.addRental(new Rental(childrensMovie, 3));

        String statement = customer.statement();

        assertEquals("Rental record for Charlie Child\n" +
                "\tSpongeBob and the Sentence Enhancers\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void costGeneratedCorrectlyForRegularMovie() {
        Customer customer = new Customer("Rodney Regular");
        Movie regularMovie = new Movie("The Joys of Being Regular", Movie.REGULAR);
        customer.addRental(new Rental(regularMovie, 3));

        String statement = customer.statement();

        assertEquals("Rental record for Rodney Regular\n" +
                "\tThe Joys of Being Regular\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void costGeneratedCorrectlyForMultiDayMultiMovieRental() {
        Customer customer = new Customer("Brenda BingeWatcher");
        Movie regularMovie = new Movie("The Joys of Being Regular", Movie.REGULAR);
        Movie childrensMovie = new Movie("SpongeBob and the Sentence Enhancers", Movie.CHILDREN);
        Movie newReleaseMovie = new Movie("New Release Movie", Movie.NEW_RELEASE);

        customer.addRental(new Rental(regularMovie, 5));
        customer.addRental(new Rental(childrensMovie, 5));
        customer.addRental(new Rental(newReleaseMovie, 5));

        String statement = customer.statement();

        assertEquals("Rental record for Brenda BingeWatcher\n" +
                "\tThe Joys of Being Regular\t6.5\n" +
                "\tSpongeBob and the Sentence Enhancers\t4.5\n" +
                "\tNew Release Movie\t15.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points", statement);
    }
}

