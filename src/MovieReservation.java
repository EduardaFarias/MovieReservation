import exception.MovieAlreadyReservedException;
import exception.MovieNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieReservation {
    private List<Movie> movies;

    public MovieReservation(){
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public Movie findMovieByTitle(String title){
        return movies.stream().filter(f -> f.getTitle().equals(title)).findFirst().orElse(null);
    }

    public List<Movie> getAvailableMovie(){
        return movies.stream().filter(movie -> !movie.isReserved()).collect(Collectors.toList());
    }

    public void reserveMovie(int movieId, int userId) throws MovieNotFoundException, MovieAlreadyReservedException {
        Movie movie = movies.stream()
                .filter(d -> d.getId() == movieId)
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
        if (movie.isReserved()) {
            throw new MovieAlreadyReservedException("Movie already reserved");
        }
        movie.setReserved(true);
    }

}
