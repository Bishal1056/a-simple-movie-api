package dev.blahblah56.movies.service;

import dev.blahblah56.movies.Movie;
import dev.blahblah56.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//database access methods here
@Service
public class MovieService {
    //either by creating a constructor or auto-wire to instantiate the class for us
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        //System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}
