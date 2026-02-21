package dev.karwan.movieanalysis;

import java.util.List;

public class MovieAnalyzer {

    public long howManyMoviesFrom1975(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getYear() == 1975).count();
    }
}
