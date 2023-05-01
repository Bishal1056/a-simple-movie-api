package dev.blahblah56.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

//class represent each document in the movies' collection. annotation to mark that
@Document(collection = "moviess")
// this annotation take cares of all the getter and setter methods.
@Data
//annotation for creating constructor with all the variables.
@AllArgsConstructor
public class Movie {
    //unique identifier
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    //embedded relationship. (1 to * relationship) but for a manual relationship to store only ids by database and in a separate collection - annotation
    @DocumentReference
    private List<Review> reviewIds;

}
