package dev.karwan.movieanalysis;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoDBAtlasDownload {

    MovieAnalyzer analyzer = new MovieAnalyzer();

    public MongoDBAtlasDownload() {

        // Connect to MongoDB Atlas
        String uri = "mongodb+srv://<your-username>:<your-password>@<yourCluster>.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            //Get all movies from 1975
            List<Movie> movieList = new ArrayList<>();
            for (Document doc : moviesCollection.find(new Document("year", 1975))) {
                {
                    movieList.add(Movie.fromDocument(doc));
                }
            }

            //Use functions from MovieAnalyzer to get statistics about the movies
            System.out.println("Amount of movies: "+ analyzer.howManyMoviesFrom1975(movieList));
            System.out.println("Length of longest movie: "+ analyzer.lengthOfLongestMovie(movieList));
            System.out.println("Amount of unique genres "+ analyzer.howManyUniqueGenres(movieList));
            System.out.println("Actors in highest rated movie "+ analyzer.actorsInHighestRatedMovie(movieList));
            System.out.println("Movie with fewest actors "+ analyzer.movieWithTheFewestActorsListed(movieList));
            System.out.println("Amount of unique languages: "+ analyzer.allUniqueLanguages(movieList));
           // System.out.println("Has doublette titles: "+sm.anyDoubletteTitles(movieList));
           // System.out.println("Amount of actors in more movies "+sm.amountOfActorsInMoreThanOneMovie(movieList));
           // System.out.println("Actor in the most movies: "+sm.actorInTheMostMovies(movieList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MongoDBAtlasDownload m = new MongoDBAtlasDownload();
    }
}