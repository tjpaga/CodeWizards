
package com.example.vehiclebooking;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = VehicleBookingApplication.class)
public class CucumberSpringConfiguration {
}
