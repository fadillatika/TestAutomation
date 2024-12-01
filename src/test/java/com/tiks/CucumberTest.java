package com.tiks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        glue = {"com.tiks"},
        features = {"src/test/resources/featuresUI"},
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber"}
)
public class CucumberTest {
}
