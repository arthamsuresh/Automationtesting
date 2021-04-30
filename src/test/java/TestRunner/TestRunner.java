package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

//import org.junit.runner.RunWith;
	

@RunWith(Cucumber.class)



@CucumberOptions(

features = "src/test/java/features",

glue= {"stepDefinition","utilities"},

tags = {"@tag1"},
plugin = { "pretty"}



)

public class TestRunner {



}





