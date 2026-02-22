package dev.karwan.movieanalysis;

import java.util.Comparator;
import java.util.List;

public class MovieAnalyzer {

    public long howManyMoviesFrom1975(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getYear() == 1975).count();
    }
    public int lengthOfLongestMovie(List<Movie> movies) {
        return movies.stream().mapToInt(movie -> movie.getRuntime()).max().orElse(0);
    }
    public long howManyUniqueGenres(List<Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getGenres().stream()).distinct().count();
    }

    public List<String> actorsInHighestRatedMovie(List<Movie> movies) {
        return movies.stream().max(Comparator.comparingDouble(Movie::getImdbRating)).get().getCast();
    }
}
