package com.lcwr.hotel.controller;


import com.lcwr.hotel.entity.Hotel;
import com.lcwr.hotel.service.HotelService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @PreAuthorize("hasAuthority('Admin')")
@PostMapping
public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
{
    return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
}

@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
@GetMapping
public ResponseEntity <List<Hotel>> getAll()
{
           List<Hotel> hotel1= hotelService.getAll();
           return ResponseEntity.ok(hotel1);

}

    @PreAuthorize("hasAuthority('SCOPE_internal')")
@GetMapping("/{hotelId}")
public  ResponseEntity <Hotel> getHotel(@PathVariable String hotelId)
{

return  ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));


}




}
