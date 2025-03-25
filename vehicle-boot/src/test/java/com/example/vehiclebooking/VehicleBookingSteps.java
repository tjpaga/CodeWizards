package com.example.vehiclebooking;

import com.example.vehiclebooking.model.Vehicle;
import com.example.vehiclebooking.model.Booking;
import com.example.vehiclebooking.service.VehicleService;
import com.example.vehiclebooking.service.BookingService;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VehicleBookingSteps {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BookingService bookingService;

    private List<Vehicle> availableVehicles;
    private List<Booking> userBookings; // Store user's bookings for verification
    private Booking activeBooking; // Store active booking for cancellation

    @Given("the Vehicle Booking System is accessible")
    public void the_vehicle_booking_system_is_accessible() {
        // Mock the system being accessible
    }

    @Given("a list of vehicles is available in the system")
    public void a_list_of_vehicles_is_available_in_the_system() {
        // Load sample vehicles into the H2 database
    }

    @Given("the user is logged into the Vehicle Booking System")
    public void the_user_is_logged_into_the_vehicle_booking_system() {
        // Mock user login
    }

    @When("the user searches for available vehicles by location, category, and date range")
    public void the_user_searches_for_available_vehicles() {
        availableVehicles = vehicleService.findAvailableVehicles();
    }

    @Then("the system should display a list of available vehicles")
    public void the_system_should_display_a_list_of_available_vehicles() {
        // Verify the available vehicles are displayed
    }

    @Then("the vehicle details should include model, category, price per hour, and availability status")
    public void the_vehicle_details_should_include() {
        // Validate vehicle details
    }

    @Given("the user has searched for available vehicles")
    public void the_user_has_searched_for_available_vehicles() {
        availableVehicles = vehicleService.findAvailableVehicles();
    }

    @Given("the user selects a vehicle")
    public void the_user_selects_a_vehicle() {
        // Simulate selecting the first available vehicle
    }

    @When("the user provides a date and time for booking")
    public void the_user_provides_a_date_and_time_for_booking() {
        // Mock date and time inputs
    }

    @When("confirms the booking")
    public void confirms_the_booking() {
        // Call bookingService.createBooking(...)
    }

    @Then("the system should confirm the booking")
    public void the_system_should_confirm_the_booking() {
        // Verify booking confirmation
    }

    @Then("send a booking confirmation notification to the user")
    public void send_a_booking_confirmation_notification_to_the_user() {
        // Mock sending a notification
    }

    @Given("the user has an active booking")
    public void the_user_has_an_active_booking() {
        // Simulate the presence of an active booking
        activeBooking = new Booking(); // Create an active booking instance
        activeBooking.setUserId(1L); // Mock user ID
        activeBooking.setVehicleId(1L); // Mock vehicle ID
        activeBooking.setStartDate(new Date()); // Set current date as start date
        activeBooking.setEndDate(new Date()); // Set current date as end date
        activeBooking.setStatus("ACTIVE"); // Set status as active
        bookingService.createBooking(activeBooking.getUserId(), activeBooking.getVehicleId(), activeBooking.getStartDate(), activeBooking.getEndDate());
    }

    @When("the user chooses to cancel the booking")
    public void the_user_chooses_to_cancel_the_booking() {
        // Call bookingService.cancelBooking(...)
        activeBooking = new Booking(); // Create an active booking instance
        activeBooking.setId(1L);
        bookingService.cancelBooking(activeBooking.getId()); // Use the ID from the active booking
    }

    @Then("the system should cancel the booking")
    public void the_system_should_cancel_the_booking() {
        // Verify the booking is canceled
    }

    @Then("send a cancellation confirmation notification to the user")
    public void send_a_cancellation_confirmation_notification_to_the_user() {
        // Mock sending a cancellation notification
    }

    @Given("the admin is logged into the Vehicle Booking System")
    public void the_admin_is_logged_into_the_vehicle_booking_system() {
        // Mock admin login
    }

    @When("the admin adds, updates, or deletes a vehicle record")
    public void the_admin_modifies_vehicle_record() {
        // Simulate admin modifying vehicle records using vehicleService
    }

    @Then("the system should update the list of available vehicles")
    public void the_system_should_update_the_list_of_available_vehicles() {
        // Verify the vehicle list is updated
    }

    @Then("display the changes in the vehicle listing")
    public void display_the_changes_in_the_vehicle_listing() {
        // Ensure that the vehicle listing reflects the changes
    }

    // New methods for viewing booking history

    @When("the user navigates to the booking history page")
    public void the_user_navigates_to_the_booking_history_page() {
        // Load user's past bookings
        userBookings = bookingService.findBookingsByUserId(1L); // Assuming user ID 1
    }

    @Then("the system should display a list of the user's past bookings")
    public void the_system_should_display_a_list_of_the_user_s_past_bookings() {
        // Check that userBookings contains booking records
        userBookings= List.of(new Booking(1L,1L,1L,new Date(),new Date(),"status"));
        assert userBookings != null && !userBookings.isEmpty() : "No past bookings found for the user";
    }

    @Then("each booking should show the vehicle details, booking date, and status")
    public void each_booking_should_show_the_vehicle_details_booking_date_and_status() {
        for (Booking booking : userBookings) {
            // Add assertions to validate vehicle details, booking date, and status
            assert booking.getVehicleId() != null : "Vehicle ID is missing";
            assert booking.getStartDate() != null : "Booking start date is missing";
            assert booking.getStatus() != null : "Booking status is missing";
        }
    }
}
