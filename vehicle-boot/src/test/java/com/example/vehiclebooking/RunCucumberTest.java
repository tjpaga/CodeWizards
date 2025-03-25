
package com.example.vehiclebooking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.vehiclebooking",
    plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)
public class RunCucumberTest {
}
