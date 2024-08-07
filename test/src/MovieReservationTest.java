import exception.MovieAlreadyReservedException;
import exception.MovieNotFoundException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieReservationTest {
    @Test
    public void testMovieReservationFindByTitle() {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.addMovie(new Movie(1, "Avatar", false));
        movieReservation.addMovie(new Movie(2, "Barbie: Fairytopia", false));

        assertNotNull(movieReservation.findMovieByTitle("Avatar"));
        assertNull(movieReservation.findMovieByTitle("Divertidamente 2"));
    }

    @Test
    public void testGetAvailableMovies() {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.addMovie(new Movie(1, "Matrix", false));
        movieReservation.addMovie(new Movie(2, "Inception", true));

        List<Movie> availableMovies = movieReservation.getAvailableMovie();
        assertEquals(1, availableMovies.size());
        assertEquals("Matrix", availableMovies.get(0).getTitle());
    }


    @Test
    public void testReserveMovie() {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.addMovie(new Movie(1, "Mulan", true));

        assertTrue(movieReservation.findMovieByTitle("Mulan").isReserved());
    }

    @Test
    public void testReserveNonExistingMovie() {
        MovieReservation movieReservation = new MovieReservation();

        Exception exception = assertThrows(MovieNotFoundException.class, () -> movieReservation.reserveMovie(1, 1001));
        assertEquals("Movie not found", exception.getMessage());
    }

    @Test
    public void testReserveAlreadyReservedMovie() throws MovieNotFoundException, MovieAlreadyReservedException {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.addMovie(new Movie(1, "The Matrix", false));
        movieReservation.reserveMovie(1, 1001);

        Exception exception = assertThrows(MovieAlreadyReservedException.class, () -> movieReservation.reserveMovie(1, 1002));
        assertEquals("Movie already reserved", exception.getMessage());
    }
}
