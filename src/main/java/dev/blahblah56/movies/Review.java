package dev.blahblah56.movies;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @BsonProperty("id")
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }
}
