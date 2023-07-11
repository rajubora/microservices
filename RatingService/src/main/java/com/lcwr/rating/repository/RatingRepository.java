package com.lcwr.rating.repository;

import com.lcwr.rating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository  extends MongoRepository<Rating, String> {
// custom Finder Method

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String userId);




}
