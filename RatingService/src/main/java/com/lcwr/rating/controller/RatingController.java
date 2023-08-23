package com.lcwr.rating.controller;


import com.lcwr.rating.entity.Rating;
import com.lcwr.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
   public ResponseEntity<List<Rating>> getRatings()
   {
       return ResponseEntity.ok(ratingService.getRatings());

   }

   @GetMapping("users/{userId}")
      public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){

      return ResponseEntity.ok(ratingService.getAllByUserId(userId));

      }
    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel( @PathVariable String hotelId){

        return ResponseEntity.ok(ratingService.getAllByHotelId(hotelId));

    }




}
