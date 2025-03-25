Feature: Vehicle Booking System
  The Vehicle Booking System allows users to search, book, manage, and cancel vehicle bookings through an online platform. The system supports various vehicle categories and provides detailed vehicle information.

  Background:
    Given the Vehicle Booking System is accessible
    And a list of vehicles is available in the system

  Scenario: User searches for available vehicles
    Given the user is logged into the Vehicle Booking System
    When the user searches for available vehicles by location, category, and date range
    Then the system should display a list of available vehicles
    And the vehicle details should include model, category, price per hour, and availability status

  Scenario: User books a vehicle
    Given the user has searched for available vehicles
    And the user selects a vehicle
    When the user provides a date and time for booking
    And confirms the booking
    Then the system should confirm the booking
    And send a booking confirmation notification to the user

  Scenario: User views booking history
    Given the user is logged into the Vehicle Booking System
    When the user navigates to the booking history page
    Then the system should display a list of the user's past bookings
    And each booking should show the vehicle details, booking date, and status

  Scenario: User cancels a booking
    Given the user has an active booking
    When the user chooses to cancel the booking
    Then the system should cancel the booking
    And send a cancellation confirmation notification to the user

  Scenario: Admin manages vehicle listings
    Given the admin is logged into the Vehicle Booking System
    When the admin adds, updates, or deletes a vehicle record
    Then the system should update the list of available vehicles
    And display the changes in the vehicle listing
