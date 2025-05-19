package com.java.tekarch.sfdc.pom.tests;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "src/test/resources/features",
	glue = "cucumber.java.stepdefs"
	)


public class runTest { }