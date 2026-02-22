package dev.karwan.movieanalysis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class MovieAnalyzerTest {

    MovieAnalyzer analyzer = new MovieAnalyzer();

    List<Movie> testMovies = List.of(
            new Movie("1", "The Bear", 1975, List.of("Drama"), "Steven Spielberg", List.of("Tom Cruise","Tom Hanks"), 8.3, List.of("English"), 125),
            new Movie("2", "The Fish", 1975, List.of("Comedy", "Romance"), "Quentin Tarantino", List.of("Morgan Freeman","Mel Gibson"), 8.3, List.of("English"), 125),
            new Movie("3", "Heist", 1980, List.of("Drama"), "Christopher Nolan", List.of("Brad Pitt"), 7.2, List.of("Spanish"), 240),
            new Movie("4", "The Hunt", 1995, List.of("Horror"), "Christopher Nolan", List.of("Brad Pitt","Robin Williams"), 9.3, List.of("Swedish"), 172),
            new Movie("5", "The Hunt", 1965, List.of("Horror", "Drama"), "George Lucas", List.of("Will Smith"), 6.3, List.of("Russian"), 142)
            );

    @Test
    void testHowManyMoviesFrom1975() {
        long expected = 2;
        long actual = analyzer.howManyMoviesFrom1975(testMovies);
        assert actual == expected;
    }

    @Test
    void lengthOfLongestMovie() {
        int expected = 240;
        int actual = analyzer.lengthOfLongestMovie(testMovies);
        assert actual == expected;
    }

    @Test
    void howManyUniqueGenres() {
        long expected = 4;
        long actual = analyzer.howManyUniqueGenres(testMovies);
        assert actual == expected;
    }

    @Test
    void actorsInHighestRatedMovie() {
        List<String> expected = List.of("Brad Pitt","Robin Williams");
        List<String> actual = analyzer.actorsInHighestRatedMovie(testMovies);
        Assertions.assertEquals(expected, actual);
    }


}
