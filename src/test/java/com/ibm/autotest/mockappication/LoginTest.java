package com.ibm.autotest.mockappication;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by wu on 4/1/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\autotest\\src\\test\\resources\\MockApp",
        format = {"pretty","json:target/cucumber.json"},
        tags = {"@login"}
)
public class LoginTest {}

