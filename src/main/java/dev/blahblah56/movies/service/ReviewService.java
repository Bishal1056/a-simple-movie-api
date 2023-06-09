package dev.blahblah56.movies.service;

import dev.blahblah56.movies.Movie;
import dev.blahblah56.movies.Review;
import dev.blahblah56.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String body, String imdbId) {
        Review review = reviewRepository.insert(new Review(body));

        //find the one movie from imdbId and push review to the array. specified search better handled by template.
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

    public String getReview(String imdbId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("imdbId").is(imdbId));
        String[] parts = mongoTemplate.find(query, Movie.class).toString().split(",");
        //not an ideal solution. will handle bson id issue later on.
        return parts[parts.length-1];
    }
}
