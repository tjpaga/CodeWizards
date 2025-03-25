package com.example.vehiclebooking.controller;

import com.example.vehiclebooking.model.Booking;
import com.example.vehiclebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestParam Long userId,
                                                  @RequestParam Long vehicleId,
                                                  @RequestParam Date startDate,
                                                  @RequestParam Date endDate) {
        Booking booking = bookingService.createBooking(userId, vehicleId, startDate, endDate);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.findBookingsByUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }
}
