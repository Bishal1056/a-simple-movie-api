package dev.blahblah56.movies.controller;

import dev.blahblah56.movies.Review;
import dev.blahblah56.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.createReview(payload.get("body"), payload.get("imdbId")), HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<String> getReview(@PathVariable String imdbId) {
        return new ResponseEntity<>(reviewService.getReview(imdbId), HttpStatus.OK);
    }
}
