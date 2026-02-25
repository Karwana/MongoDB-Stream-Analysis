package dev.karwan.movieanalysis;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieAnalyzer {

    public long howManyMoviesFrom1975(List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getYear() == 1975).count();
    }

    public int lengthOfLongestMovie(List<Movie> movies) {
        return movies.stream().mapToInt(Movie::getRuntime).max().orElse(0);
    }

    public long howManyUniqueGenres(List<Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getGenres().stream()).distinct().count();
    }

    public List<String> actorsInHighestRatedMovie(List<Movie> movies) {
        return movies.stream().max(Comparator.comparingDouble(Movie::getImdbRating)).get().getCast();
    }

    public String movieWithTheFewestActorsListed(List<Movie> movies) {
        return movies.stream().min(Comparator.comparingInt(movie -> movie.getCast().size())).get().getTitle();
    }

    public long allUniqueLanguages(List<Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getLanguages().stream()).distinct().count();
    }

    public boolean anyDoubletteTitles(List<Movie> movies) {
        long totalMovies = movies.size();
        long uniqueTitles = movies.stream().map(Movie::getTitle).distinct().count();
        return totalMovies != uniqueTitles;
    }

    public long amountOfActorsInMoreThanOneMovie(List<Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getCast().stream()).collect(Collectors.groupingBy
                (actor -> actor, Collectors.counting())).values().stream().filter(count -> count > 1).count();
    }

    public String actorInTheMostMovies(List<Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getCast().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Ingen skådespelare hittades");
    }
    // HOF
    public long filterMovies(List<Movie> movies, Predicate<Movie> condition) {
        return movies.stream().filter(condition).count();
    }

}
