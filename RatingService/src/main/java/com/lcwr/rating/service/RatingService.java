package com.lcwr.rating.service;

import com.lcwr.rating.entity.Rating;

import java.util.List;

public interface RatingService {


    //create
    Rating create(Rating rating);


    //get all rating
    List<Rating> getRatings();



    // get all by userID
    List<Rating> getAllByUserId(String userId);


    //get all by hotel
     List<Rating> getAllByHotelId(String hotelId);


}
